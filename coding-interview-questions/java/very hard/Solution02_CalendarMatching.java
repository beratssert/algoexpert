import java.util.*;

class Program {
  // O(c1 + c2) time | O(c1 + c2) space - c1, and c2 are respective numbers of
  // meetings in the calendar1 and calendar2.
  public static List<StringMeeting> calendarMatching(
      List<StringMeeting> calendar1,
      StringMeeting dailyBounds1,
      List<StringMeeting> calendar2,
      StringMeeting dailyBounds2,
      int meetingDuration) {

    List<int[]> updatedCalendar1 = updatedCalendar(calendar1, dailyBounds1);
    List<int[]> updatedCalendar2 = updatedCalendar(calendar2, dailyBounds2);
    List<int[]> mergedCalendars = mergedCalendars(updatedCalendar1, updatedCalendar2);
    List<int[]> flattenedCalendars = flattenedCalendars(mergedCalendars);

    return minutesToMilitaryTime(getAvailableTimeIntervals(flattenedCalendars, meetingDuration));
  }

  public static List<int[]> updatedCalendar(List<StringMeeting> calendar, StringMeeting dailyBounds) {
    List<StringMeeting> updatedCalendar = new ArrayList<>();
    updatedCalendar.add(new StringMeeting("0:00", dailyBounds.start));
    updatedCalendar.addAll(calendar);
    updatedCalendar.add(new StringMeeting(dailyBounds.end, "23:59"));
    return militaryTimeToMinutes(updatedCalendar);
  }

  public static List<int[]> mergedCalendars(List<int[]> calendar1, List<int[]> calendar2) {
    List<int[]> mergedCalendars = new ArrayList<>();
    int i = 0;
    int j = 0;

    while (i < calendar1.size() && j < calendar2.size()) {
      if (calendar1.get(i)[0] < calendar2.get(j)[0]) {
        mergedCalendars.add(calendar1.get(i));
        i++;
      } else {
        mergedCalendars.add(calendar2.get(j));
        j++;
      }
    }

    while (i < calendar1.size()) {
      mergedCalendars.add(calendar1.get(i));
      i++;
    }

    while (j < calendar2.size()) {
      mergedCalendars.add(calendar2.get(j));
      j++;
    }

    return mergedCalendars;
  }

  public static List<int[]> flattenedCalendars(List<int[]> calendar) {
    List<int[]> flatenedCalendars = new ArrayList<>();
    flatenedCalendars.add(calendar.get(0));
    for (int i = 1; i < calendar.size(); i++) {
      int[] currentMeeting = calendar.get(i);
      int[] lastFlattenedMeeting = flatenedCalendars.get(flatenedCalendars.size() - 1);
      if (lastFlattenedMeeting[1] > currentMeeting[0]) {
        lastFlattenedMeeting[1] = Math.max(lastFlattenedMeeting[1], currentMeeting[1]);
      } else {
        flatenedCalendars.add(currentMeeting);
      }
    }

    return flatenedCalendars;
  }

  public static List<int[]> militaryTimeToMinutes(List<StringMeeting> calendar) {
    List<int[]> updatedCalendar = new ArrayList<>();
    for (StringMeeting meeting : calendar) {
      String[] start = meeting.start.split(":");
      String[] end = meeting.end.split(":");
      updatedCalendar.add(new int[] { Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]),
          Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) });
    }

    return updatedCalendar;
  }

  public static List<StringMeeting> minutesToMilitaryTime(List<int[]> calendar) {
    List<StringMeeting> updatedCalendar = new ArrayList<>();
    for (int[] meeting : calendar) {
      int startHours = meeting[0] / 60;
      int startMinutes = meeting[0] % 60;
      int endHours = meeting[1] / 60;
      int endMinutes = meeting[1] % 60;

      String stringStartMinutes = startMinutes < 10 ? "0" + startMinutes : startMinutes + "";
      String stringEndMinutes = endMinutes < 10 ? "0" + endMinutes : endMinutes + "";

      StringMeeting updatedMeeting = new StringMeeting(startHours + ":" + stringStartMinutes,
          endHours + ":" + stringEndMinutes);
      updatedCalendar.add(updatedMeeting);
    }

    return updatedCalendar;
  }

  public static List<int[]> getAvailableTimeIntervals(List<int[]> calendar, int duration) {
    List<int[]> availableTimeIntervals = new ArrayList<>();
    for (int i = 1; i < calendar.size(); i++) {
      int[] current = calendar.get(i);
      int[] prev = calendar.get(i - 1);
      if (current[0] - prev[1] >= duration)
        availableTimeIntervals.add(new int[] { prev[1], current[0] });
    }

    return availableTimeIntervals;
  }

  static class StringMeeting {
    public String start;
    public String end;

    public StringMeeting(String start, String end) {
      this.start = start;
      this.end = end;
    }
  }

  // O(c1 * c2) time | O(c1 + c2) space - c1, and c2 are respective numbers of
  // meetings in the calendar1 and calendar2.
  // public static List<StringMeeting> calendarMatching(
  // List<StringMeeting> calendar1,
  // StringMeeting dailyBounds1,
  // List<StringMeeting> calendar2,
  // StringMeeting dailyBounds2,
  // int meetingDuration) {

  // List<StringMeeting> avaliableTimeIntervalsForCalendar1 =
  // getAvaliableTimeIntervals(calendar1, dailyBounds1);
  // List<StringMeeting> avaliableTimeIntervalsForCalendar2 =
  // getAvaliableTimeIntervals(calendar2, dailyBounds2);
  // List<StringMeeting> availableTimeIntervalsForMeeting =
  // calculateAvailableTimeIntervals(
  // avaliableTimeIntervalsForCalendar1, avaliableTimeIntervalsForCalendar2,
  // meetingDuration);

  // return availableTimeIntervalsForMeeting;
  // }

  // public static List<StringMeeting>
  // getAvaliableTimeIntervals(List<StringMeeting> calendar, StringMeeting
  // dailyBounds) {
  // List<StringMeeting> availableTimeIntervals = new ArrayList<>();

  // String dayStart = dailyBounds.start;
  // String dayEnd = dailyBounds.end;
  // String start = dayStart;
  // for (StringMeeting stringMeeting : calendar) {
  // if (!stringMeeting.start.equals(start))
  // availableTimeIntervals.add(new StringMeeting(start, stringMeeting.start));
  // start = stringMeeting.end;
  // }

  // if (!start.equals(dayEnd))
  // availableTimeIntervals.add(new StringMeeting(start, dayEnd));

  // return availableTimeIntervals;
  // }

  // public static List<StringMeeting>
  // calculateAvailableTimeIntervals(List<StringMeeting> timeInterval1,
  // List<StringMeeting> timeInterval2, int duration) {
  // List<StringMeeting> availableTimeIntervals = new ArrayList<>();

  // for (StringMeeting interval1 : timeInterval1) {
  // for (StringMeeting interval2 : timeInterval2) {
  // if (!shareSameIntervalBlock(interval1, interval2))
  // continue;

  // String start = getTime(interval1.start, interval2.start, true);
  // String end = getTime(interval1.end, interval2.end, false);

  // if (timeDifference(start, end) >= duration)
  // availableTimeIntervals.add(new StringMeeting(start, end));
  // }

  // }

  // return availableTimeIntervals;
  // }

  // public static boolean shareSameIntervalBlock(StringMeeting interval1,
  // StringMeeting interval2) {
  // if ((timeDifference(interval2.end, interval1.start) >= 0 ||
  // timeDifference(interval1.end, interval2.start) >= 0))
  // return false;

  // return true;
  // }

  // public static String getTime(String time1, String time2, boolean isStart) {
  // int timeDifference = timeDifference(time1, time2);
  // if (timeDifference > 0)
  // return isStart ? time2 : time1;

  // return isStart ? time1 : time2;
  // }

  // public static int timeDifference(String start, String end) {
  // int startHour = Integer.parseInt(start.split(":")[0]);
  // int startMinute = Integer.parseInt(start.split(":")[1]);
  // int endHour = Integer.parseInt(end.split(":")[0]);
  // int endMinute = Integer.parseInt(end.split(":")[1]);

  // int endTotalMinutes = endHour * 60 + endMinute;
  // int startTotalMinutes = startHour * 60 + startMinute;

  // return endTotalMinutes - startTotalMinutes;
  // }

  // static class StringMeeting {
  // public String start;
  // public String end;

  // public StringMeeting(String start, String end) {
  // this.start = start;
  // this.end = end;
  // }
  // }
}
