// package lab1.task2;

// import java.util.HashMap;
// import java.util.Map;

// public class SimpleUrl {
//     String protocol;
//     String address;
//     String domainZone;
//     String siteName;
//     String path;
//     String webpageName;
//     String webPageExtension;
//     Map<String, String> parameters;
    
//     // Конструктор
//     public SimpleUrl() {
//         this.parameters = new HashMap<>();
//     }
    
//     // Геттеры
//     public String getProtocol() {
//         return protocol;
//     }
    
//     public String getAddress() {
//         return address;
//     }
    
//     public String getDomainZone() {
//         return domainZone;
//     }
    
//     public String getSiteName() {
//         return siteName;
//     }
    
//     public String getPath() {
//         return path;
//     }
    
//     public String getWebpageName() {
//         return webpageName;
//     }
    
//     public String getWebPageExtension() {
//         return webPageExtension;
//     }
    
//     public Map<String, String> getParameters() {
//         return parameters;
//     }
    
//     // Сеттеры
//     public void setProtocol(String protocol) {
//         this.protocol = protocol;
//     }
    
//     public void setAddress(String address) {
//         this.address = address;
//     }
    
//     public void setDomainZone(String domainZone) {
//         this.domainZone = domainZone;
//     }
    
//     public void setSiteName(String siteName) {
//         this.siteName = siteName;
//     }
    
//     public void setPath(String path) {
//         this.path = path;
//     }
    
//     public void setWebpageName(String webpageName) {
//         this.webpageName = webpageName;
//     }
    
//     public void setWebPageExtension(String webPageExtension) {
//         this.webPageExtension = webPageExtension;
//     }
    
//     public void setParameters(Map<String, String> parameters) {
//         this.parameters = parameters;
//     }
    
//     public void addParameter(String key, String value) {
//         this.parameters.put(key, value);
//     }
    
//     // Переопределение метода toString()
//     @Override
//     public String toString() {
//         StringBuilder sb = new StringBuilder();
//         sb.append("protocol = ").append(protocol).append("\n")
//           .append("address = ").append(address).append("\n")
//           .append("domainZone = ").append(domainZone).append("\n")
//           .append("siteName = ").append(siteName).append("\n")
//           .append("path = ").append(path).append("\n")
//           .append("webpageName = ").append(webpageName).append("\n")
//           .append("webPageExtension = ").append(webPageExtension).append("\n")
//           .append("parameters = ").append(parameters);
        
//         return sb.toString();
//     }
// }

