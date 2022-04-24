package br.org.rodnet.testeopenfeign.soap.dataaccess;

import br.com.vr.dataaccess.stub.NumberToDollars;
import br.com.vr.dataaccess.stub.NumberToDollarsResponse;
import br.com.vr.dataaccess.stub.NumberToWords;
import br.com.vr.dataaccess.stub.NumberToWordsResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DataAccessSOAPTest {

    @Autowired
    private DataAccessSOAP dataAccessSOAP;

    @Test
    void escreverNumeroPorExtenso(){
        NumberToWords request = new NumberToWords();
        request.setUbiNum(BigInteger.TEN);

        NumberToWordsResponse response = dataAccessSOAP.porExtenso(request);

        assertThat(response.getNumberToWordsResult().trim()).isEqualToIgnoringCase("ten");
    }

    @Test
    void escreverValorEmDolaresPorExtenso(){
        NumberToDollars request = new NumberToDollars();
        request.setDNum(new BigDecimal("10.51"));

        NumberToDollarsResponse response = dataAccessSOAP.dolaresPorExtenso(request);

        assertThat(response.getNumberToDollarsResult().trim()).isEqualToIgnoringCase("ten dollars and fifty one cents");
    }
}
