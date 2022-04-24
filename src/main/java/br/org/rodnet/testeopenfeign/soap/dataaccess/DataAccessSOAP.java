package br.org.rodnet.testeopenfeign.soap.dataaccess;

import br.com.vr.dataaccess.stub.NumberToDollars;
import br.com.vr.dataaccess.stub.NumberToDollarsResponse;
import br.com.vr.dataaccess.stub.NumberToWords;
import br.com.vr.dataaccess.stub.NumberToWordsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "dataAccess",
        url = "${dataaccess.soap.url}",
        configuration = DataAccessSOAPConfiguration.class)
interface DataAccessSOAP {

    @PostMapping(produces = MediaType.TEXT_XML_VALUE, consumes = MediaType.TEXT_XML_VALUE)
    NumberToWordsResponse porExtenso(@RequestBody NumberToWords request);

    @PostMapping(produces = MediaType.TEXT_XML_VALUE, consumes = MediaType.TEXT_XML_VALUE)
    NumberToDollarsResponse dolaresPorExtenso(@RequestBody NumberToDollars request);
}
