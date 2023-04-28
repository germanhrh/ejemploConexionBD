package test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import test.utils.ManejoArchivos;
import test.utils.ConexionBDOracle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static io.restassured.RestAssured.given;
import static test.enums.RequestCaeFull.REQUEST_CONSULTAR_CLIENTE_MOTOR;


class ConsultarClienteMotorTest {


    ConexionBDOracle conexionBDOracle;
    ResultSet rs;

//http://middlewareuat.falabella.cl/bco/co/12c/soa/soa-infra/services/banco/BCO_CO_Cliente_Admision_Evaluar-v2_0/BPELClienteAdmisionEvaluar
    @BeforeAll
    static void setUp() {RestAssured.baseURI = "http://middlewaretest.falabella.cl/";}
    //static void setUp() {
    //    RestAssured.baseURI = "http://middlewareuat.falabella.cl/";
    //}


    public static Object[][] cedulaClientes() {
        return new Object[][]{


            //oficina, primerApellido, nacionalidad, tipoDocumento,	numeroDocumento, cListas, deptoResidencia, actividadEconomica, ingresos, producto, EscoreEsperado
                /*
                {"36", "PARADA", "5", "1", "19370080", "1", "3", "2", "10000000", "2", "2.5"},
                {"36", "HERNANDEZ", "11", "1", "17581309", "1", "15", "6", "10000000", "1", "2.1"},
                {"36", "VARGAS", "14", "1", "19112366", "1", "11", "2", "10000000", "1", "2.3"},
                {"36", "ARIAS", "2", "1", "16471527", "1", "25", "3", "10000000", "1", "2.4"},
                {"36", "PINEDA", "13", "1", "70549701", "0", "3", "15", "10000000", "1", "2.4"},
                {"36", "PICO", "13", "1", "91204572", "1", "34", "15", "10000000", "1", "2.5"}

                {"36", "KATTAN", "14", "1", "16933712", "1", "2", "10", "10000000", "3", "2.5"},
                {"36", "ORTEGA", "8", "1", "35467920", "1", "20", "11", "10000000", "1", "2.3"},
                {"36", "RAMIREZ", "13", "1", "21068897", "1", "5", "2", "10000000", "1", "2.1"},
                {"36", "VERGARA", "19", "1", "41491850", "1", "24", "3", "10000000", "1", "2.3"},
                {"36", "VELANDIA", "5", "1", "41540566", "1", "26", "8", "1000000", "1", "2.3"},
                {"36", "RUIZ", "11", "1", "40760716", "1", "2", "8", "2500000", "1", "2.4"},
                {"170", "MINNIG", "8", "1", "31206065", "1", "1", "3", "10000000", "1", "2.4"},
                {"36", "CASTILLO", "14", "1", "10264963", "1", "15", "3", "10000000", "1", "2.5"}

                 */
//oficina, primerApellido, nacionalidad, tipoDocumento,	numeroDocumento, cListas, deptoResidencia, actividadEconomica, ingresos, producto, EscoreEsperado

                {"211", "KATTAN", "13", "1", "16933712", "1", "5", "3", "10000000", "1", "2.5"}
                /*
                {"36", "KATTAN", "14", "1", "16933712", "1", "91", "10", "10000000", "3", "2.5"},
                {"36", "PARADA", "5", "1", "19370080", "1", "81", "2", "10000000", "2", "2.5"},
                //{"36", "HERNANDEZ", "11", "1", "17581309", "1", "27", "6", "10000000", "1", "2.1"},
                {"36", "ORTEGA", "8", "1", "35467920", "1", "94", "11", "10000000", "1", "2.3"},
                //{"36", "RAMIREZ", "13", "1", "21068897", "1", "8", "2", "10000000", "1", "2.1"},
                {"36", "VARGAS", "14", "1", "19112366", "1", "18", "2", "10000000", "1", "2.3"},
                {"36", "VERGARA", "19", "1", "41491850", "1", "52", "3", "10000000", "1", "2.3"},
                {"36", "ARIAS", "2", "1", "16471527", "1", "54", "3", "10000000", "1", "2.4"},
                {"36", "VELANDIA", "5", "1", "41540566", "1", "86", "8", "1000000", "1", "2.3"},
                {"36", "RUIZ", "11", "1", "40760716", "1", "91", "8", "2500000", "1", "2.4"},
                {"170", "MINNIG", "8", "1", "31206065", "1", "5", "3", "10000000", "1", "2.4"},
                {"36", "PINEDA", "13", "1", "70549701", "0", "81", "15", "10000000", "1", "2.4"},
                {"36", "CASTILLO", "14", "1", "10264963", "1", "27", "3", "10000000", "1", "2.5"},
                {"36", "PICO", "13", "1", "91204572", "1", "14", "15", "10000000", "1", "2.5"}
*/


        };
    }


    @ParameterizedTest
    @MethodSource("cedulaClientes")
    void registrarClienteOmnichannel(String oficina, String primerApellido, String nacionalidad, String tipoDocumento,
                                     String numeroDocumento, String cListas, String deptoResidencia, String actividadEconomica,
                                     String ingresos, String producto, String score) throws SQLException {

        Response responseCliente = given().accept(ContentType.XML)
                .header("Content-Type", "text/xml; charset=utf-8")
                .body(String.format(REQUEST_CONSULTAR_CLIENTE_MOTOR.getRequest(), oficina, primerApellido, nacionalidad, tipoDocumento,
                        numeroDocumento, cListas, deptoResidencia, actividadEconomica, ingresos))
                .log().all(true)
                .post("bco/co/12c/soa/soa-infra/services/banco/BCO_CO_Cliente_Admision_Evaluar-v2_0/BPELClienteAdmisionEvaluar")
                .then().log().all(true)
                .extract().response();
        String mensaje = responseCliente.xmlPath()
                .getString("Envelope.Body.clienteAdmisionEvaluarMsgResp.estadoOperacion.glosaOperacion");

        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(10*1000);
        } catch (Exception e) {
            System.out.println(e);
        }

        String sql;
        sql = "SELECT  CAF_FILLER1N6  FROM SOR.MDH_RESULT_PRODUCTO WHERE RPR_NUMERO_DOCUMENTO = '"+numeroDocumento+"' AND rownum = 1 ORDER BY RPR_FECHA_REGISTRO DESC";
        float valor = 0;

        Connection cn = conexionBDOracle.conectarQA();
        if(cn!=null) {
            System.out.println("Conectados consulta");
            Statement stm = cn.createStatement();
            rs = stm.executeQuery(sql);
        }

        while(rs.next())
        {
            System.out.println(rs.getFloat(1)/100);
            valor = rs.getFloat(1)/100;
        }


        if (Float.toString(valor).equals(score)) {
            ManejoArchivos.agregarClientesArchivo(numeroDocumento, Float.toString(valor), score,"src/test/resources/data/score_correctos.csv");
        } else
            ManejoArchivos.agregarClientesArchivo(numeroDocumento, Float.toString(valor), score, "src/test/resources/data/score_incorrectos.csv");

        Assertions.assertEquals(score, Float.toString(valor));
        Assertions.assertEquals("CONTINUA", mensaje);
    }
}
