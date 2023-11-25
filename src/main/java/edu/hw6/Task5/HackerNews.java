package edu.hw6.Task5;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hacker News - это сайт с актуальными обсуждениями технологических тенденций. Доступ к статьям осуществляется через веб-сервис, а документацию можно найти на сайте https://github.com/HackerNews/API.
 * Нас интересуют 2 endpoint'а:
 * https://hacker-news.firebaseio.com/v0/topstories.json: возвращает JSON-массив с идентификаторами наиболее обсуждаемых статей.
 * https://hacker-news.firebaseio.com/v0/item/37570037.json: возвращает JSON-объект,
 * содержащий сообщение с идентификатором 37570037.
 * Задание
 * Создайте класс HackerNews.
 * Реализуйте метод long[] hackerNewsTopStories(), который будет
 * делать HTTP-запрос при помощи HttpClient к https://hacker-news.firebaseio.com/v0/topstories.json
 * конвертировать возвращаемый JSON в long[]
 * В общем случае для чтения JSON используются специальные парсеры,
 * но т.к. структура массива очень простая, то можем обойтись без них. В реальном приложении, конечно
 * ,мы бы использовали библиотеку, например, Jackson.
 * В случае ошибки ввода-вывода должен быть возвращен пустой массив.
 * Напишите метод String news(long id), который возвращает название новости.
 * Для получения имени новости используйте регулярное выражение.
 * Пример:
 * System.out.println(Arrays.toString(hackerNewsTopStories()));
 * String newsTitle = news(37570037);
 * System.out.println(newsTitle);
 */
public class HackerNews {
    private static final String BASE_URL = "https://hacker-news.firebaseio.com/v0/";
    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();

    private HackerNews() {

    }

    public static long[] hackerNewsTopStories() {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(BASE_URL + "topstories.json"))
            .build();

        try {
            HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            String[] ids = response.body().replaceAll("[\\[\\]\"]", "").split(",");
            long[] result = new long[ids.length];
            for (int i = 0; i < ids.length; i++) {
                result[i] = Long.parseLong(ids[i].trim());
            }
            return result;
        } catch (IOException | InterruptedException e) {
            System.err.println("Error while fetching top stories: " + e.getMessage());
            return new long[0];
        }
    }

    public static String news(long id) {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(BASE_URL + "item/" + id + ".json"))
            .build();

        try {
            HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            String title = "";
            Pattern pattern = Pattern.compile("\"title\":\"([^\"]+)\"");
            Matcher matcher = pattern.matcher(response.body());
            if (matcher.find()) {
                title = matcher.group(1);
            }
            return title;
        } catch (IOException | InterruptedException e) {
            System.err.println("Error while fetching news: " + e.getMessage());
            return "";
        }
    }
}
