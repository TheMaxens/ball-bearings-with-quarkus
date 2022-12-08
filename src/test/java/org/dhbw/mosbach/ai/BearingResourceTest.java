package org.dhbw.mosbach.ai;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

import javax.ws.rs.core.MediaType;

@QuarkusTest
public class BearingResourceTest {

    @Test
    public void testGet() {
        given().when().get("/bearing").then().statusCode(200).contentType(MediaType.APPLICATION_JSON).body("$.size()", is(0));
    }

    @Test
    public void testCreate() {
        given().header("Content-Type", "application/json").body("{\"id\": 0,\"bearingA\": {\"id\": 0,\"cdyn\": 0,\"y\": 0,\"e\": 0,\"xB1\": 0,\"p\": 0,\"fr\": 0,\"fa\": 0,\"lh10\": 0},\"bearingB\": {\"id\": 0,\"cdyn\": 0,\"y\": 0,\"e\": 0,\"xB1\": 0,\"p\": 0,\"fr\": 0,\"fa\": 0,\"lh10\": 0},\"xD1\": 0,\"xD2\": 0,\"load\": {\"id\": 0,\"fr\": 0,\"fa\": 0,\"n\": 0,\"xr\": 0,\"ya\": 0},\"a\": 0,\"b\": 0,\"c\": 0,\"lh10\": 0}").when().post("/bearing").then().statusCode(201).contentType(MediaType.APPLICATION_JSON).body("a", equalTo(0F), "b", equalTo(0F), "c", equalTo(0F));
    }

    @Test
    public void testUpdate() {
        // given().header("Content-Type", "application/json").body("{\"id\": 0,\"bearingA\": {\"id\": 0,\"cdyn\": 0,\"y\": 0,\"e\": 0,\"xB1\": 0,\"p\": 0,\"fr\": 0,\"fa\": 0,\"lh10\": 0},\"bearingB\": {\"id\": 0,\"cdyn\": 0,\"y\": 0,\"e\": 0,\"xB1\": 0,\"p\": 0,\"fr\": 0,\"fa\": 0,\"lh10\": 0},\"xD1\": 0,\"xD2\": 0,\"load\": {\"id\": 0,\"fr\": 0,\"fa\": 0,\"n\": 0,\"xr\": 0,\"ya\": 0},\"a\": 12,\"b\": 15,\"c\": 20,\"lh10\": 0}").when().put("/bearing/{id}", 1).then().statusCode(200).contentType(MediaType.APPLICATION_JSON).body("a", is(equalTo(12F)), "b", is(equalTo(15F)), "c", is(equalTo(20F)));
    
        given().header("Content-Type", "application/json").body("{\"id\": 0,\"bearingA\": {\"id\": 0,\"cdyn\": 0,\"y\": 0,\"e\": 0,\"xB1\": 0,\"p\": 0,\"fr\": 0,\"fa\": 0,\"lh10\": 0},\"bearingB\": {\"id\": 0,\"cdyn\": 0,\"y\": 0,\"e\": 0,\"xB1\": 0,\"p\": 0,\"fr\": 0,\"fa\": 0,\"lh10\": 0},\"xD1\": 0,\"xD2\": 0,\"load\": {\"id\": 0,\"fr\": 0,\"fa\": 0,\"n\": 0,\"xr\": 0,\"ya\": 0},\"a\": 12,\"b\": 15,\"c\": 20,\"lh10\": 0}").when().put("/bearing/{id}", 1).then().statusCode(200).contentType(MediaType.APPLICATION_JSON).body(is("{\"id\": 5,\"bearingA\": {\"id\": 6,\"cdyn\": 0,\"y\": 0,\"e\": 0,\"xB1\": 0,\"p\": 0,\"fr\": 0,\"fa\": 0,\"lh10\": 0},\"bearingB\": {\"id\": 7,\"cdyn\": 0,\"y\": 0,\"e\": 0,\"xB1\": 0,\"p\": 0,\"fr\": 0,\"fa\": 0,\"lh10\": 0},\"xD1\": 0,\"xD2\": 0,\"load\": {\"id\": 8,\"fr\": 0,\"fa\": 0,\"n\": 0,\"xr\": 0,\"ya\": 0},\"a\": 12,\"b\": 15,\"c\": 20,\"lh10\": 0}"));
    }

}
