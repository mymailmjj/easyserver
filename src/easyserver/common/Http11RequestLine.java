package easyserver.common;

public class Http11RequestLine {
    
    private RequestType requestType;   //请求类型
    
    private String requestUrl;
    
    private String protocol = "HTTP/1.1";
    
    
    public enum RequestType{
        
        GET("GET"),POST("POST");
        
        public String reeuestMethod;

        private RequestType(String reeuestMethod) {
            this.reeuestMethod = reeuestMethod;
        }
    }


    public RequestType getRequestType() {
        return requestType;
    }


    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }


    public String getRequestUrl() {
        return requestUrl;
    }


    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }


    public String getProtocol() {
        return protocol;
    }


    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
    
    
    
}
    