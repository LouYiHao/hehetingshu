package com.hehe.HttpUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map; 
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair; 
public class HttpUtils {     
    /**
36      * get
37      * 
38      * @param host
39      * @param path
40      * @param method
41      * @param headers
42      * @param querys
43      * @return
44      * @throws Exception
45      */
     public static HttpResponse doGet(String host, String path, String method, 
             Map<String, String> headers, 
             Map<String, String> querys)
             throws Exception {        
         HttpClient httpClient = wrapClient(host);
 
         HttpGet request = new HttpGet(buildUrl(host, path, querys));
         for (Map.Entry<String, String> e : headers.entrySet()) {
             request.addHeader(e.getKey(), e.getValue());
         }
        
         return httpClient.execute(request);
     }
     
     /**
61      * post form
62      * 
63      * @param host
64      * @param path
65      * @param method
66      * @param headers
67      * @param querys
68      * @param bodys
69      * @return
70      * @throws Exception
71      */
     public static HttpResponse doPost(String host, String path, String method, 
             Map<String, String> headers, 
             Map<String, String> querys, 
             Map<String, String> bodys)
             throws Exception {        
         HttpClient httpClient = wrapClient(host);
         
         HttpPost request = new HttpPost(buildUrl(host, path, querys));
         for (Map.Entry<String, String> e : headers.entrySet()) {
             request.addHeader(e.getKey(), e.getValue());
         }
 
         if (bodys != null) {
             List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
 
             for (String key : bodys.keySet()) {
                 nameValuePairList.add(new BasicNameValuePair(key, bodys.get(key)));
            }
             UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(nameValuePairList, "utf-8");
             formEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
             request.setEntity(formEntity);
         }
 
         return httpClient.execute(request);
     }    
     
     /**
99      * Post String
100      * 
101      * @param host
102      * @param path
103      * @param method
104      * @param headers
105      * @param querys
106      * @param body
107      * @return
108      * @throws Exception
109      */
     public static HttpResponse doPost(String host, String path, String method, 
             Map<String, String> headers, 
             Map<String, String> querys, 
             String body)
             throws Exception {        
         HttpClient httpClient = wrapClient(host);
 
        HttpPost request = new HttpPost(buildUrl(host, path, querys));
         for (Map.Entry<String, String> e : headers.entrySet()) {
             request.addHeader(e.getKey(), e.getValue());
         } 
         if (StringUtils.isNotBlank(body)) {
             request.setEntity(new StringEntity(body, "utf-8"));
         }
 
         return httpClient.execute(request);
     }
     
     /**
130      * Post stream
131      * 
132      * @param host
133      * @param path
134      * @param method
135      * @param headers
136      * @param querys
137      * @param body
138      * @return
139      * @throws Exception
140      */
     public static HttpResponse doPost(String host, String path, String method, 
             Map<String, String> headers, 
             Map<String, String> querys, 
            byte[] body)
            throws Exception {        
         HttpClient httpClient = wrapClient(host);
 
         HttpPost request = new HttpPost(buildUrl(host, path, querys));
         for (Map.Entry<String, String> e : headers.entrySet()) {
             request.addHeader(e.getKey(), e.getValue());
         }
 
         if (body != null) {
             request.setEntity(new ByteArrayEntity(body));
         }
 
         return httpClient.execute(request);
     }
     
     /**
161      * Put String
162      * @param host
163      * @param path
164      * @param method
165      * @param headers
166      * @param querys
167      * @param body
168      * @return
169      * @throws Exception
170      */
     public static HttpResponse doPut(String host, String path, String method, 
             Map<String, String> headers, 
             Map<String, String> querys, 
             String body)
             throws Exception {        
         HttpClient httpClient = wrapClient(host);
 
         HttpPut request = new HttpPut(buildUrl(host, path, querys));
         for (Map.Entry<String, String> e : headers.entrySet()) {
             request.addHeader(e.getKey(), e.getValue());
         }

         if (StringUtils.isNotBlank(body)) {
             request.setEntity(new StringEntity(body, "utf-8"));
         }
 
         return httpClient.execute(request);
    }
     
     /**
191      * Put stream
192      * @param host
193      * @param path
194      * @param method
195      * @param headers
196      * @param querys
197      * @param body
198      * @return
199      * @throws Exception
200      */
     public static HttpResponse doPut(String host, String path, String method, 
             Map<String, String> headers, 
             Map<String, String> querys, 
             byte[] body)
             throws Exception {        
         HttpClient httpClient = wrapClient(host);
 
         HttpPut request = new HttpPut(buildUrl(host, path, querys));
        for (Map.Entry<String, String> e : headers.entrySet()) {
             request.addHeader(e.getKey(), e.getValue());
         }
 
         if (body != null) {
             request.setEntity(new ByteArrayEntity(body));
         }
 
         return httpClient.execute(request);
     }
     
     /**
221      * Delete
222      *  
223      * @param host
224      * @param path
225      * @param method
226      * @param headers
227      * @param querys
228      * @return
229      * @throws Exception
230      */
     public static HttpResponse doDelete(String host, String path, String method, 
             Map<String, String> headers, 
             Map<String, String> querys)
             throws Exception {        
         HttpClient httpClient = wrapClient(host);
 
         HttpDelete request = new HttpDelete(buildUrl(host, path, querys));
         for (Map.Entry<String, String> e : headers.entrySet()) {
             request.addHeader(e.getKey(), e.getValue());
         }
         
         return httpClient.execute(request);
     }
     
     private static String buildUrl(String host, String path, Map<String, String> querys) throws UnsupportedEncodingException {
         StringBuilder sbUrl = new StringBuilder();
         sbUrl.append(host);
         if (!StringUtils.isBlank(path)) {
             sbUrl.append(path);
         }
         if (null != querys) {
             StringBuilder sbQuery = new StringBuilder();
             for (Map.Entry<String, String> query : querys.entrySet()) {
                 if (0 < sbQuery.length()) {
                     sbQuery.append("&");
                 }
                 if (StringUtils.isBlank(query.getKey()) && !StringUtils.isBlank(query.getValue())) {
                    sbQuery.append(query.getValue());
                 }
                 if (!StringUtils.isBlank(query.getKey())) {
                     sbQuery.append(query.getKey());
                     if (!StringUtils.isBlank(query.getValue())) {
                         sbQuery.append("=");
                        sbQuery.append(URLEncoder.encode(query.getValue(), "utf-8"));
                     }                    
                 }
             }
             if (0 < sbQuery.length()) {
                 sbUrl.append("?").append(sbQuery);
             }
         }
         
         return sbUrl.toString();
     }
     
     private static HttpClient wrapClient(String host) {
         HttpClient httpClient = new DefaultHttpClient();
         if (host.startsWith("https://")) {
             sslClient(httpClient);
         }
         
         return httpClient;
     }
    
     private static void sslClient(HttpClient httpClient) {
        try {
             SSLContext ctx = SSLContext.getInstance("TLS");
             X509TrustManager tm = new X509TrustManager() {
                 public X509Certificate[] getAcceptedIssuers() {
                     return null;
                 }
                 public void checkClientTrusted(X509Certificate[] xcs, String str) {
                    
                 }
                 public void checkServerTrusted(X509Certificate[] xcs, String str) {
                     
                 }
             };
             ctx.init(null, new TrustManager[] { tm }, null);
             SSLSocketFactory ssf = new SSLSocketFactory(ctx);
             ssf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
             ClientConnectionManager ccm = httpClient.getConnectionManager();
             SchemeRegistry registry = ccm.getSchemeRegistry();
             registry.register(new Scheme("https", 443, ssf));
         } catch (KeyManagementException ex) {
             throw new RuntimeException(ex);
         } catch (NoSuchAlgorithmException ex) {
             throw new RuntimeException(ex);
         }
     }
 }
