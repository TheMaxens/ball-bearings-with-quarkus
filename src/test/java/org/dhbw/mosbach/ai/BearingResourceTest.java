package org.dhbw.mosbach.ai;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.both;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import javax.ws.rs.core.MediaType;

import org.dhbw.mosbach.ai.domain.entity.Bearing;
import org.dhbw.mosbach.ai.domain.entity.Load;
import org.dhbw.mosbach.ai.domain.entity.OArrangement;
import org.dhbw.mosbach.ai.domain.vo.Id;
import org.dhbw.mosbach.ai.framework.adapters.input.rest.request.CreateBearing;
import org.dhbw.mosbach.ai.framework.adapters.input.rest.request.CreateLoad;
import org.dhbw.mosbach.ai.framework.adapters.input.rest.request.CreateOArrangement;
import org.hamcrest.collection.IsArray;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BearingResourceTest {

    @Test
    @Order(1)
    public void testGet() {
        given()
                .when()
                .get("/bearing")
                .then()
                .statusCode(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body("$", hasSize(0));
    }

    @Test
    @Order(2)
    public void testCreate() {
        CreateBearing createBearingA = CreateBearing.builder().cdyn(12000).y(0.4).e(1.4).xb1(40).build();
        CreateBearing createBearingB = CreateBearing.builder().cdyn(12000).y(0.4).e(1.4).xb1(40).build();
        CreateLoad createLoad = CreateLoad.builder().fr(2000).fa(100).n(500).xr(25).ya(10).build();
        CreateOArrangement createOArrangement = CreateOArrangement.builder().bearing_a(createBearingA).bearing_b(createBearingB).xd1(30).xd2(50).load(createLoad).build();

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(createJsonFromObject(createOArrangement))
                .when()
                .post("/bearing")
                .then()
                .statusCode(200);

        given()
                .when()
                .get("/bearing")
                .then()
                .statusCode(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body("size()", is(1), "[0].a", equalTo(10F), "[0].b", equalTo(15F), "[0].c", equalTo(100F), "[0].lh10", both(greaterThan(8330F)).and(lessThan(8331F)), "[0].bearing_a.lh10", both(greaterThan(8330F)).and(lessThan(8331F)), "[0].bearing_b.lh10", both(greaterThan(67776F)).and(lessThan(67777F)));
    }

    @Test
    @Order(3)
    public void testUpdate() {
        // change load.fr from 2000 to 3000
        CreateBearing createBearingA = CreateBearing.builder().cdyn(12000).y(0.4).e(1.4).xb1(40).build();
        CreateBearing createBearingB = CreateBearing.builder().cdyn(12000).y(0.4).e(1.4).xb1(40).build();
        CreateLoad createLoad = CreateLoad.builder().fr(3000).fa(100).n(500).xr(25).ya(10).build();
        CreateOArrangement createOArrangement = CreateOArrangement.builder().bearing_a(createBearingA).bearing_b(createBearingB).xd1(30).xd2(50).load(createLoad).build();

        OArrangement[] oArrangements = given()
                .when()
                .get("/bearing")
                .then()
                .extract().as(OArrangement[].class);
        String id = oArrangements[0].id.getUuid().toString();
        
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(createJsonFromObject(createOArrangement))
                .when()
                .put("/bearing/{id}", id)
                .then()
                .statusCode(200)
                .body("load.fr", equalTo(3000F));

        given()
                .when()
                .get("/bearing")
                .then()
                .statusCode(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body("size()", is(1), "[0].load.fr", equalTo(3000F));
    }

    @Test
    @Order(4)
    public void testGetSingle() {
        OArrangement[] oArrangements = given()
                .when()
                .get("/bearing")
                .then()
                .extract().as(OArrangement[].class);
        String id = oArrangements[0].id.getUuid().toString();

        given()
                .when()
                .get("/bearing/{id}", id)
                .then()
                .statusCode(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body("id.uuid", equalTo(id), "load.fr", equalTo(3000F));
    }

    @Test
    @Order(5)
    public void testDelete() {
        OArrangement[] oArrangements = given()
                .when()
                .get("/bearing")
                .then()
                .extract().as(OArrangement[].class);
        String id = oArrangements[0].id.getUuid().toString();

        given()
                .when()
                .delete("/bearing/{id}", id)
                .then()
                .statusCode(200)
                .body(is("true"));

        given()
                .when()
                .get("/bearing")
                .then()
                .statusCode(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body("size()", is(0));
    }

    // helper function to create a JSON from an object
    private String createJsonFromObject(Object object) {
        ObjectMapper om = new ObjectMapper();
        String json = "";
        try {
            json = om.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
