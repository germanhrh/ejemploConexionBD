package test.enums;

public enum RequestCaeFull {

    REQUEST_CONSULTAR_CLIENTE_MOTOR("<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
            "   <soap:Header>\n" +
            "      <ns1:ClientService xmlns:ns1=\"http://mdwcorp.falabella.com/common/schema/clientservice\">\n" +
            "         <ns1:country>CO</ns1:country>\n" +
            "         <ns1:commerce>Banco</ns1:commerce>\n" +
            "         <ns1:channel>Web</ns1:channel>\n" +
            "         <ns1:storeId>%s</ns1:storeId>\n" +
            "         <ns1:date>2015-07-09</ns1:date>\n" +
            "      </ns1:ClientService>\n" +
            "      <ns1:ClientServiceFIF xmlns:ns1=\"http://mdwcorp.falabella.com/common/schema/clientserviceFIF\"/>\n" +
            "   </soap:Header>\n" +
            "   <soap:Body>\n" +
            "      <ns4:clienteAdmisionEvaluarMsgReq xmlns:ns4=\"http://mdwcorp.falabella.com/BCO/CO/SOA/schema/Cliente/Admision/Evaluar/Req-v2017.10\">\n" +
            "         <ns4:cliente>\n" +
            "            <apellidoMaterno>RODRIGUEZ</apellidoMaterno>\n" +
            "            <apellidoPaterno>%s</apellidoPaterno>\n" +
            "            <fechaNacimiento>1995-12-20</fechaNacimiento>\n" +
            "            <genero>2</genero>\n" +
            "            <nacionalidad>%s</nacionalidad>\n" +
            "            <documentoIdentidad>\n" +
            "               <tipoDocumento>%s</tipoDocumento>\n" +
            "               <numeroDocumento>%S</numeroDocumento>\n" +
            "            </documentoIdentidad>\n" +
            "\t\t\t<listaRestrictiva>\n" +
            "               <codigo>%s</codigo>\n" +
            "            </listaRestrictiva>\n" +
            "            <primerNombre>JEIMY PAOLA</primerNombre>\n" +
            "            <segundoNombre></segundoNombre>\n" +
            "            <ns4:informacionContacto>\n" +
            "               <telefono>\n" +
            "                  <numeroTelefono>3112134241</numeroTelefono>\n" +
            "                  <tipoTelefono>3</tipoTelefono>\n" +
            "               </telefono>\n" +
            "\t\t\t   <direccion>\n" +
            "                  <codigoCiudad>13001</codigoCiudad>\n" +
            "               </direccion>\n" +
            "               <correoElectronico>\n" +
            "                  <direccionCorreoElectronico>Jeimi799104@hotmail.com</direccionCorreoElectronico>\n" +
            "               </correoElectronico>\n" +
            "                  <departamento>%s</departamento>\n" +
            "            </ns4:informacionContacto>\n" +
            "            <ns4:actividadLaboral>\n" +
            "               <descripcionActividad>%s</descripcionActividad>\n" +
            "               <montoRentaLiquida>5000000</montoRentaLiquida>\n" +
            "            </ns4:actividadLaboral>\n" +
            "            <ns4:informacionAdicional>\n" +
            "               <fechaExpedicion>2013-12-30</fechaExpedicion>\n" +
            "               <totalIngresos>%s</totalIngresos>\n" +
            "               <empleadoGrupo>false</empleadoGrupo>\n" +
            "            </ns4:informacionAdicional>\n" +
            "         </ns4:cliente>\n" +
            "         <ns4:productos>\n" +
            "        <ns4:producto>\n" +
            "          <codigoProducto>1</codigoProducto>\n" +
            "        </ns4:producto>\n" +
            "      </ns4:productos>\n" +
            "      <ns4:productos>\n" +
            "        <ns4:producto>\n" +
            "          <codigoProducto>2</codigoProducto>\n" +
            "        </ns4:producto>\n" +
            "      </ns4:productos>\n" +
            "      <ns4:productos>\n" +
            "        <ns4:producto>\n" +
            "          <codigoProducto>7</codigoProducto>\n" +
            "        </ns4:producto>\n" +
            "      </ns4:productos>" +
            "<ns4:atributoFlexible>\n" +
            "        <nombreAtributo>tipoEvaluacion</nombreAtributo>\n" +
            "        <valorAtributo>3</valorAtributo>\n" +
            "    </ns4:atributoFlexible>"+
            "      </ns4:clienteAdmisionEvaluarMsgReq>\n" +
            "   </soap:Body>\n" +
            "</soap:Envelope>");


    private final String request;

    RequestCaeFull(String request) {
        this.request = request;
    }
    public String getRequest() {
        return request;
    }
}
