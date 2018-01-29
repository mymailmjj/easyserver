/**
 * 
 */
package parsetest;

import java.nio.ByteBuffer;

/**
 * 
 * GET /5foIcy0a2gI2n2jgoY3K/static/fisp_static/common/resource/js/usermonitor_88a158c.js?v=1.2 HTTP/1.1
    Host: gss0.bdstatic.com
    Connection: keep-alive
    User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36
    Referer: http://news.baidu.com/
    Accept-Encoding: gzip, deflate
    Accept-Language: zh-CN,zh;q=0.9
    If-Modified-Since: Wed, 20 Dec 2017 03:03:35 GMT
 * @author cango
 * 测试解析http header的方法
 *
 */
public class ParseMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        StringBuffer sb = new StringBuffer();
        
        sb.append("GET /5foIcy0a2gI2n2jgoY3K/static/fisp_static/common/resource/js/usermonitor_88a158c.js?v=1.2 HTTP/1.1\n");
        sb.append("Host: gss0.bdstatic.com\n");
        sb.append("Connection: keep-alive\n");
        sb.append("User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36\n");
        sb.append("Accept: */*\n");
        sb.append("Referer: http://news.baidu.com/\n");
        sb.append("Accept-Encoding: gzip, deflate\n");
        sb.append("Accept-Language: zh-CN,zh;q=0.9\n");
        sb.append("If-Modified-Since: Wed, 20 Dec 2017 03:03:35 GMT\n");
        
        String string = sb.toString();
        
        ByteBuffer w = ByteBuffer.wrap(string.getBytes());
        
        while(w.hasRemaining()){
            byte b = w.get();
            System.out.print((char)b);
        }
        
        
    }

}
