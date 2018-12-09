package tz.co.comptech.m_safariproduction.Model;/*
*
* m-safari App
* By GrandMaster
* 2018 Nov
*
*/


import java.util.ArrayList;

public class BusSchedule {
 private String company_id;
 private String bus_id;
 private BusCenter from;
 private BusCenter to;
 private String estimated_time;
 private String sch_date;
 private String departure_time;
 private String arrival_time;
 FareLevel fare_per_level;
 ArrayList< PassingPoint > passing_points = new ArrayList < PassingPoint > ();
 ArrayList < BookedSeat > booked_seat = new ArrayList < BookedSeat > ();
 ArrayList < PrevSeatHolder > prev_seat_holders = new ArrayList < PrevSeatHolder > ();
 private String trip_status;
 private String cancellation_policy;
 private String help_line_no;
 private float min_booking_hrs;
 private String created_by_worker_id;
 private String created_date;
 private String updated_date;


 // Getter Methods 

 }