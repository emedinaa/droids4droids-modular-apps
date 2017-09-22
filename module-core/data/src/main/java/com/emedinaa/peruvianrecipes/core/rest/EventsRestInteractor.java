package com.emedinaa.peruvianrecipes.core.rest;

import com.emedinaa.peruvianrecipes.core.callback.StorageCallback;
import com.emedinaa.peruvianrecipes.core.interactors.EventsInteractor;
import com.emedinaa.peruvianrecipes.core.mapper.EventMapper;
import com.emedinaa.peruvianrecipes.core.rest.entity.EventList;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by eduardomedina on 7/12/16.
 */
public class EventsRestInteractor implements EventsInteractor {

    private static final String TAG = "EventsRestInteractor";
    private final EventMapper eventMapper;

    public EventsRestInteractor(EventMapper eventMapper) {
        this.eventMapper = eventMapper;
    }

    @Override
    public void events(String group_urlname, final StorageCallback storageCallback) {
        Map<String, String> options = new HashMap<>();
        options.put("key",Constants.MEETUPKEY);
        options.put("sign","true");
        options.put("photo-host","public");
        options.put("status","upcoming");
        //status
        options.put("group_urlname", group_urlname);
        options.put("page", "200");

        Call<EventList> call= ApiClient.getMyApiClient().eventsByGroup(options);
        call.enqueue(new Callback<EventList>() {
            @Override
            public void onResponse(Call<EventList> call, Response<EventList> response) {
                if(response.isSuccessful()){
                    EventList eventList= response.body();
                    if(eventList!=null){
                        storageCallback.onSuccess(
                                eventMapper.transformList(eventList.getResults()));
                    }else{
                        Exception exception= new Exception("Error");
                        storageCallback.onFailure(exception);
                    }
                }else {

                }
            }

            @Override
            public void onFailure(Call<EventList> call, Throwable t) {
                String message="Error ";
                try {
                    message= new StringBuffer().append(t.getMessage()).toString();
                }catch (NullPointerException e) {}

                Exception exception= new Exception(message);
                storageCallback.onFailure(exception);
            }
        });
    }

    @Override
    public void pastEvents(String group_urlname, final StorageCallback storageCallback) {

        Map<String, String> options = new HashMap<>();
        options.put("key",Constants.MEETUPKEY);
        options.put("sign","true");
        options.put("photo-host","public");
        options.put("status","upcoming,past");
        //options.put("status","upcoming,past");
        options.put("group_urlname", group_urlname);
        options.put("page", "200");

        Call<EventList> call= ApiClient.getMyApiClient().eventsByGroup(options);

        call.enqueue(new Callback<EventList>() {
            @Override
            public void onResponse(Call<EventList> call, Response<EventList> response) {
                if(response.isSuccessful()){
                    EventList eventList= response.body();
                    if(eventList!=null){
                        storageCallback.onSuccess(
                                eventMapper.transformList(eventList.getResults()));
                    }else{
                        Exception exception= new Exception("Error");
                        storageCallback.onFailure(exception);
                    }
                }else {

                }
            }

            @Override
            public void onFailure(Call<EventList> call, Throwable t) {
                String message="Error ";
                try {
                    message= new StringBuffer().append(t.getMessage()).toString();
                }catch (NullPointerException e) {}

                Exception exception= new Exception(message);
                storageCallback.onFailure(exception);
            }
        });
    }
}
