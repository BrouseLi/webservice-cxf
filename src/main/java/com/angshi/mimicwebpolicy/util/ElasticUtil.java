package com.angshi.mimicwebpolicy.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.angshi.mimicwebpolicy.Entity.*;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class ElasticUtil {
    @Autowired
    private RestHighLevelClient client;

    public static String INDEX_TEST = null;
    public static String TYPE_TEST = null;
    public static Tests tests = null;
    public static List<Tests> testsList = null;
    /**
     * 创建索引
     * @param index
     * @throws IOException
     */
    public void createIndex(String index) throws IOException {
        CreateIndexRequest request = new CreateIndexRequest(index);
        CreateIndexResponse createIndexResponse = client.indices().create(request,     RequestOptions.DEFAULT);
        System.out.println("createIndex: " + JSON.toJSONString(createIndexResponse));
    }
    /**
     * 判断索引是否存在
     * @param index
     * @return
     * @throws IOException
     */
    public boolean existsIndex(String index) throws IOException {
        GetIndexRequest request = new GetIndexRequest();
        request.indices(index);
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println("existsIndex: " + exists);
        return exists;
    }

    /**
     * 获取记录信息
     * @param index
     * @param type
     * @param id
     * @throws IOException
     */
    public void get(String index, String type, String id) throws IOException {
        GetRequest getRequest = new GetRequest(index, type, id.toString());
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        System.out.println("get: " + JSON.toJSONString(getResponse));
    }
    /**
     * 搜索
     * @param index
     * @param type
     * @param name
     * @throws IOException
     */
    public void searchAccess(String index, String type, String name) throws IOException {
        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        boolBuilder.must(QueryBuilders.matchQuery("@timestamp", name)); // 这里可以根据字段进行搜索，must表示符合条件的，相反的mustnot表示不符合条件的
        // boolBuilder.must(QueryBuilders.matchQuery("id", tests.getId().toString()));
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(boolBuilder);
        sourceBuilder.from(0);
        sourceBuilder.size(100); // 获取记录数，默认100
        //sourceBuilder.fetchSource(new String[] { "id", "name" }, new String[] {}); // 第一个是获取字段，第二个是过滤的字段，默认获取全部
        SearchRequest searchRequest = new SearchRequest(index);
        searchRequest.types(type);
        searchRequest.source(sourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        //System.out.println("search: " + JSON.toJSONString(response));
        SearchHits hits = response.getHits();
        SearchHit[] searchHits = hits.getHits();
        List<NewLog> logs = new ArrayList<>();
        int eventCount = 0;
        for (SearchHit hit : searchHits) {
            eventCount++;
            //System.out.println("search -> " + hit.getSourceAsString());
            JSONObject jsonObject = JSONObject.parseObject(hit.getSourceAsString());
            //System.out.println(jsonObject.getString("remote"));
            /*封装到实体类里*/
            List<Item> li = NewAccessLog.create(jsonObject.getString("ip"),jsonObject.getString("timestamp"),jsonObject.getString("verb"),jsonObject.getString("request"),jsonObject.getString("status"),jsonObject.getString("size"),jsonObject.getString("website"),jsonObject.getString("remote"));
            NewLog Log=new NewLog("accesslog","1.00","","拟态web访问日志",li);
            logs.add(Log);
            /*String s=ObjToXml.convertToXml(log);
            System.out.println(s);*/
        }
        NewAccessLog newAccessLog = new NewAccessLog(logs,String.valueOf(eventCount));
        System.out.println(newAccessLog.toString());
    }

    public void searchWarn(String index, String type, String name) throws IOException {
        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        boolBuilder.must(QueryBuilders.matchQuery("@timestamp", name)); // 这里可以根据字段进行搜索，must表示符合条件的，相反的mustnot表示不符合条件的
        // boolBuilder.must(QueryBuilders.matchQuery("id", tests.getId().toString()));
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(boolBuilder);
        sourceBuilder.from(0);
        sourceBuilder.size(100); // 获取记录数，默认100
        //sourceBuilder.fetchSource(new String[] { "id", "name" }, new String[] {}); // 第一个是获取字段，第二个是过滤的字段，默认获取全部
        SearchRequest searchRequest = new SearchRequest(index);
        searchRequest.types(type);
        searchRequest.source(sourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        //System.out.println("search: " + JSON.toJSONString(response));
        SearchHits hits = response.getHits();
        SearchHit[] searchHits = hits.getHits();
        List<NewLog> logs = new ArrayList<>();
        int eventCount = 0;
        for (SearchHit hit : searchHits) {
            eventCount++;
            //System.out.println("search -> " + hit.getSourceAsString());
            JSONObject jsonObject = JSONObject.parseObject(hit.getSourceAsString());
            //System.out.println(jsonObject.getString("@timestamp"));
            /*封装到实体类里*/
            List<Item> li = NewWarnLog.create(jsonObject.getString("requestBody"),jsonObject.getString("executeErrorNum"),jsonObject.getString("status1"),jsonObject.getString("length1"));
            NewLog log=new NewLog("warnlog","1.00","","拟态web告警日志",li);
            logs.add(log);
            /*String s=ObjToXml.convertToXml(log);
            System.out.println(s);*/
        }
        /*NewAccessLog newAccessLog = new NewAccessLog(logs,String.valueOf(eventCount));
        System.out.println(newAccessLog.toString());*/
        NewWarnLog warnLog = new NewWarnLog(logs,String.valueOf(eventCount));
        System.out.println(warnLog.toString());
    }

    public void searchtime(String index, String type, int duration)throws IOException{
        long etime1=System.currentTimeMillis()+duration*1000;//延时函数，单位毫秒，这里是延时秒钟
        SimpleDateFormat time2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String etime=time2.format(new Date(etime1));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());
        date=date.replaceAll(" ","T");
        etime=etime.replaceAll(" ","T");
        RangeQueryBuilder boolBuilder = QueryBuilders
                .rangeQuery("@timestamp")
                .from(date).to(etime);

        // boolBuilder.must(QueryBuilders.matchQuery("id", tests.getId().toString()));
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(boolBuilder);
        sourceBuilder.from(0);
        sourceBuilder.size(100); // 获取记录数，默认100
        //sourceBuilder.fetchSource(new String[] { "id", "name" }, new String[] {}); // 第一个是获取字段，第二个是过滤的字段，默认获取全部
        SearchRequest searchRequest = new SearchRequest(index);
        searchRequest.types(type);
        searchRequest.source(sourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        //System.out.println("search: " + JSON.toJSONString(response));
        SearchHits hits = response.getHits();
        SearchHit[] searchHits = hits.getHits();
        List<NewLog> logs = new ArrayList<>();
        int eventCount = 0;
        for (SearchHit hit : searchHits) {
            eventCount++;
            //System.out.println("search -> " + hit.getSourceAsString());
            JSONObject jsonObject = JSONObject.parseObject(hit.getSourceAsString());
            //System.out.println(jsonObject.getString("remote"));
            /*封装到实体类里*/
            List<Item> li = NewAccessLog.create(jsonObject.getString("ip"),jsonObject.getString("timestamp"),jsonObject.getString("verb"),jsonObject.getString("request"),jsonObject.getString("status"),jsonObject.getString("size"),jsonObject.getString("website"),jsonObject.getString("remote"));
            NewLog log=new NewLog("accesslog","1.00","","拟态web访问日志",li);
            logs.add(log);
        }
        NewAccessLog newAccessLog = new NewAccessLog(logs,String.valueOf(eventCount));
        System.out.println(newAccessLog.toString());
    }

    /*读取一段时间内日志，time为时间字符串，duration为time之后的时间间隔（秒）*/
    public void searchtime1(String index, String type, String time,int duration)throws IOException{
        String time2 = new String();
        time = time.replaceAll("T"," ");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d1 = df.parse(time);
            Calendar newTime = Calendar.getInstance();
            newTime.setTime(d1);
            newTime.add(Calendar.SECOND,duration);
            Date d2 = newTime.getTime();
            time2 = df.format(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        time=time.replaceAll(" ","T");
        time2=time2.replaceAll(" ","T");
        RangeQueryBuilder boolBuilder = QueryBuilders
                .rangeQuery("@timestamp")
                .from(time).to(time2);

        // boolBuilder.must(QueryBuilders.matchQuery("id", tests.getId().toString()));
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(boolBuilder);
        sourceBuilder.from(0);
        sourceBuilder.size(100); // 获取记录数，默认100
        //sourceBuilder.fetchSource(new String[] { "id", "name" }, new String[] {}); // 第一个是获取字段，第二个是过滤的字段，默认获取全部
        SearchRequest searchRequest = new SearchRequest(index);
        searchRequest.types(type);
        searchRequest.source(sourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        //System.out.println("search: " + JSON.toJSONString(response));
        SearchHits hits = response.getHits();
        SearchHit[] searchHits = hits.getHits();
        List<NewLog> logs = new ArrayList<>();
        int eventCount = 0;
        for (SearchHit hit : searchHits) {
            eventCount++;
            //System.out.println("search -> " + hit.getSourceAsString());
            JSONObject jsonObject = JSONObject.parseObject(hit.getSourceAsString());
            //System.out.println(jsonObject.getString("remote"));
            /*封装到实体类里*/
            List<Item> li = NewAccessLog.create(jsonObject.getString("ip"),jsonObject.getString("timestamp"),jsonObject.getString("verb"),jsonObject.getString("request"),jsonObject.getString("status"),jsonObject.getString("size"),jsonObject.getString("website"),jsonObject.getString("remote"));
            NewLog log=new NewLog("accesslog","1.00","","拟态web访问日志",li);
            logs.add(log);
            /*String s=ObjToXml.convertToXml(log);
            System.out.println(s);*/
        }
        NewAccessLog newAccessLog = new NewAccessLog(logs,String.valueOf(eventCount));
        System.out.println(newAccessLog.toString());
    }
}
