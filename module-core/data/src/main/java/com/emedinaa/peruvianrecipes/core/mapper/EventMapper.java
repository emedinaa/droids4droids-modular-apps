package com.emedinaa.peruvianrecipes.core.mapper;

import com.emedinaa.peruvianrecipes.core.entity.Group;
import com.emedinaa.peruvianrecipes.core.entity.GroupEntity;
import com.emedinaa.peruvianrecipes.core.entity.Meetup;
import com.emedinaa.peruvianrecipes.core.entity.MeetupEntity;
import com.emedinaa.peruvianrecipes.core.entity.Venue;
import com.emedinaa.peruvianrecipes.core.entity.VenueEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduardo on 11/12/16.
 */
public class EventMapper {

    public List<Meetup> transformList(List<MeetupEntity> meetupEntities){
        List<Meetup> meetups= new ArrayList<>();
        if(meetupEntities==null) return meetups;
        for (MeetupEntity meetupEntity:meetupEntities) {
            Meetup meetup= transform(meetupEntity);
            meetups.add(meetup);
        }
        return  meetups;
    }

    public Meetup transform(MeetupEntity meetupEntity){

        Meetup meetup= new Meetup();
        if(meetupEntity==null) return meetup;
        meetup.setId(meetupEntity.getId());
        meetup.setName(meetupEntity.getName());
        meetup.setVenue(transformVenue(meetupEntity.getVenue()));
        meetup.setStatus(meetupEntity.getStatus());
        meetup.setTime(meetupEntity.getTime());
        meetup.setWaitlist_count(meetupEntity.getWaitlist_count());
        meetup.setYes_rsvp_coun(meetupEntity.getYes_rsvp_coun());
        meetup.setLink(meetupEntity.getLink());
        meetup.setUrl(meetupEntity.getEvent_url());
        meetup.setDescription(meetupEntity.getDescription());
        meetup.setVisibility(meetupEntity.getVisibility());
        meetup.setGroup(transformGroup(meetupEntity.getGroup()));

        return  meetup;
    }

    private Group transformGroup(GroupEntity groupEntity){
        Group group = new Group();
        if(groupEntity==null)return group;
        group.setName(groupEntity.getName());
        group.setCreated(groupEntity.getCreated());
        group.setId(groupEntity.getId());
        group.setJoin_mode(groupEntity.getJoin_mode());
        group.setLat(groupEntity.getLat());
        group.setLon(groupEntity.getLon());
        group.setUrlname(groupEntity.getUrlname());
        group.setWho(groupEntity.getWho());

        return group;
    }

    private Venue transformVenue(VenueEntity venueEntity){
        Venue venue= new Venue();
        if(venueEntity==null) return venue;
        venue.setId(venueEntity.getId());
        venue.setName(venueEntity.getName());
        venue.setAddress(venueEntity.getAddress_1());
        venue.setCity(venueEntity.getCity());
        venue.setCountry(venueEntity.getCountry());
        venue.setCountryName(venueEntity.getLocalized_country_name());
        venue.setAddress(venueEntity.getAddress_1());
        return venue;
    }

}
