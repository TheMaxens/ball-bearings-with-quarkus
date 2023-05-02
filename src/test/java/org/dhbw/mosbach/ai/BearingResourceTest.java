package org.dhbw.mosbach.ai;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import javax.ws.rs.core.MediaType;

import org.dhbw.mosbach.ai.domain.entity.Bearing;
import org.dhbw.mosbach.ai.domain.entity.Load;
import org.dhbw.mosbach.ai.domain.entity.OArrangement;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.quarkus.test.junit.QuarkusTest;

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
        OArrangement object = new OArrangement(new Bearing(0, 0, 0, 0), new Bearing(0, 0, 0, 0), 0, 0,
                new Load(0, 0, 0, 0, 0), 0, 0, 0);

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(createJsonFromObject(object))
                .when()
                .post("/bearing")
                .then()
                .statusCode(201);
    }

    @Test
    @Order(3)
    public void testUpdate() {
        OArrangement object = new OArrangement(new Bearing(0, 0, 0, 0), new Bearing(0, 0, 0, 0), 0, 0,
                new Load(0, 0, 0, 0, 0), 10, 20, 30);

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(createJsonFromObject(object))
                .when()
                .put("/bearing/{id}", 1)
                .then()
                .statusCode(204);
    }

    @Test
    @Order(4)
    public void testGetSingle() {
        given()
                .when()
                .get("/bearing/{id}", 2)
                .then()
                .statusCode(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body("id", equalTo(2), "a", equalTo(10F), "b", equalTo(20F), "c", equalTo(30F));
    }

    @Test
    @Order(5)
    public void testDelete() {
        given()
                .when()
                .delete("/bearing/{id}", 2)
                .then()
                .statusCode(204);
    }

    // helper function to create a JSON from an object
    private String createJsonFromObject(OArrangement oArrangement) {
        ObjectMapper om = new ObjectMapper();
        String json = "";
        try {
            json = om.writeValueAsString(oArrangement);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
