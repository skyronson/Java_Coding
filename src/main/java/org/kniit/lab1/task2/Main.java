// package lab1.task2;

// public class Main {
//     public static void main(String[] args) {
//         // Исходный URL для парсинга
//         String url = "https://test.ru/test/1072/pagejsp";
        
//         // Создаем экземпляр класса SimpleUrl
//         SimpleUrl simpleUrl = parseUrl(url);
        
//         // Выводим информацию на экран
//         System.out.println("Информация о URL:");
//         System.out.println(simpleUrl.toString());   
//     }
    
//     public static SimpleUrl parseUrl(String url) {
//         SimpleUrl simpleUrl = new SimpleUrl();
        
//         try {
//             int protocolEndIndex = url.indexOf("://");
//             if (protocolEndIndex != -1) {
//                 simpleUrl.setProtocol(url.substring(0, protocolEndIndex));
//                 url = url.substring(protocolEndIndex + 3); // Убираем "://"
//             }
            
//             int pathStartIndex = url.indexOf('/');
//             String domainPart;
//             if (pathStartIndex != -1) {
//                 domainPart = url.substring(0, pathStartIndex);
//                 url = url.substring(pathStartIndex); // Оставляем путь и параметры
//             } else {
//                 int paramsStartIndex = url.indexOf('?');
//                 if (paramsStartIndex != -1) {
//                     domainPart = url.substring(0, paramsStartIndex);
//                     url = url.substring(paramsStartIndex);
//                 } else {
//                     domainPart = url;
//                     url = "";
//                 }
//             }
            
//             // Разделяем домен на имя сайта и зону
//             String[] domainParts = domainPart.split("\\.");
//             if (domainParts.length >= 2) {
//                 simpleUrl.setSiteName(domainParts[0]);
//                 simpleUrl.setDomainZone(domainParts[domainParts.length - 1]);
//                 simpleUrl.setAddress(domainPart);
//             }
            
//             // Парсим путь, имя страницы и расширение
//             if (!url.isEmpty() && url.contains("?")) {
//                 int paramsIndex = url.indexOf('?');
//                 String pathPart = url.substring(0, paramsIndex);
                
//                 // Парсим путь
//                 simpleUrl.setPath(pathPart);
                
//                 // Парсим имя файла и расширение
//                 int lastSlashIndex = pathPart.lastIndexOf('/');
//                 if (lastSlashIndex != -1) {
//                     String fileName = pathPart.substring(lastSlashIndex + 1);
//                     simpleUrl.setWebpageName(fileName);
                    
//                     int dotIndex = fileName.lastIndexOf('.');
//                     if (dotIndex != -1) {
//                         simpleUrl.setWebPageExtension(fileName.substring(dotIndex + 1));
//                     }
//                 }
                
//                 // Парсим параметры
//                 String paramsPart = url.substring(paramsIndex + 1);
//                 String[] params = paramsPart.split("&");
//                 for (String param : params) {
//                     String[] keyValue = param.split("=");
//                     if (keyValue.length == 2) {
//                         simpleUrl.addParameter(keyValue[0], keyValue[1]);
//                     }
//                 }
//             }
            
//         } catch (Exception e) {
//             System.out.println("Ошибка при парсинге URL: " + e.getMessage());
//         }
        
//         return simpleUrl;
//     }
// }
