//package org.bk;
//
//import org.junit.Test;
//import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//
//public class JwtTokenConverterTest {
//
//    @Test
//    public void testJwtConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setSigningKey("-----BEGIN CERTIFICATE-----\n" +
//                "MIIDNTCCAvOgAwIBAgIEMMib7zALBgcqhkjOOAQDBQAwbDEQMA4GA1UEBhMHVW5rbm93bjEQMA4G\n" +
//                "A1UECBMHVW5rbm93bjEQMA4GA1UEBxMHVW5rbm93bjEQMA4GA1UEChMHVW5rbm93bjEQMA4GA1UE\n" +
//                "CxMHVW5rbm93bjEQMA4GA1UEAxMHVW5rbm93bjAeFw0xNjA3MjcyMTAyMDVaFw0xNjEwMjUyMTAy\n" +
//                "MDVaMGwxEDAOBgNVBAYTB1Vua25vd24xEDAOBgNVBAgTB1Vua25vd24xEDAOBgNVBAcTB1Vua25v\n" +
//                "d24xEDAOBgNVBAoTB1Vua25vd24xEDAOBgNVBAsTB1Vua25vd24xEDAOBgNVBAMTB1Vua25vd24w\n" +
//                "ggG4MIIBLAYHKoZIzjgEATCCAR8CgYEA/X9TgR11EilS30qcLuzk5/YRt1I870QAwx4/gLZRJmlF\n" +
//                "XUAiUftZPY1Y+r/F9bow9subVWzXgTuAHTRv8mZgt2uZUKWkn5/oBHsQIsJPu6nX/rfGG/g7V+fG\n" +
//                "qKYVDwT7g/bTxR7DAjVUE1oWkTL2dfOuK2HXKu/yIgMZndFIAccCFQCXYFCPFSMLzLKSuYKi64QL\n" +
//                "8Fgc9QKBgQD34aCF1ps93su8q1w2uFe5eZSvu/o66oL5V0wLPQeCZ1FZV4661FlP5nEHEIGAtEkW\n" +
//                "cSPoTCgWE7fPCTKMyKbhPBZ6i1R8jSjgo64eK7OmdZFuo38L+iE1YvH7YnoBJDvMpPG+qFGQiaiD\n" +
//                "3+Fa5Z8GkotmXoB7VSVkAUw7/s9JKgOBhQACgYEA+J54teaQXtzfsknWx4axFZpOXuAms9aGihho\n" +
//                "DhmoRtb5tQXQg2lHlS8Yvw2HZoZIx5NBWVQTYBfhVBot+92LOgNwjGwl7JcNnAfc+tGzUhqNxZ4/\n" +
//                "LW9o8LcmVCrbdASlpmdeFfjcwl2wkJwNeob2SutPkj5oSKkQq6NKDVD0XuWjITAfMB0GA1UdDgQW\n" +
//                "BBRCcW0atV3JMam1ZmIISUvzfd/RGjALBgcqhkjOOAQDBQADLwAwLAIUSoTUZrXcOWEU7AqNyBRH\n" +
//                "jEGbbnYCFEXyJwxMoQvEPqkBAT8GJSm+cwW9\n" +
//                "-----END CERTIFICATE-----");
//
//        converter.setVerifierKey();
//    }
//}
