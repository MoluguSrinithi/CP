public class Test {

  public static void main(String[] args) {

    Integer i = 20;

    Integer j = i;

    i += 5;

    j -= 10;

    System.out.println(i + " " + j);

  }

}

/
import java.time.*;

import java.time.format.*;

class Test {

  public static void main(String[] args) {

    LocalDate d = LocalDate.of(2025, Month.DECEMBER, 25);

    DateTimeFormatter f =

      DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);

    System.out.println(d.format(f));

  }

}

Which of the following best represents the output format?



Question 1Answer

a.
Dec 25, 2025

b.
Thursday 25 December, 2025

c.
25-12-2025

d.
2025-12-25
Question 2
Correct
Mark 1.00 out of 1.00
Flag question
Question text
import java.util.*;

class Test {

  public static void main(String[] args) {

    List<Double> list = new ArrayList<>();

    list.add(2.5);

    list.add(new Double(4));

    double x = list.get(1);

    System.out.println(list);

    System.out.println(x);

  }

}

What is the output?



Question 2Answer

a.
[2.5, 4]

4.0


b.
[2.5, 4.0]

4.0


c.
[2.5, 4.0]

4


d.
[2.5, 4]

4

Question 3
Correct
Mark 1.00 out of 1.00
Flag question
Question text
import java.time.*;

public class Test {

    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2026, 3, 10);

        LocalTime time = LocalTime.of(5, 15);

        LocalDateTime dt =

            LocalDateTime.of(date, time)

                         .minusDays(1)

                         .minusHours(10)

                         .minusSeconds(30);

        System.out.println(dt);

    }

}

What is printed?

Question 3Answer

a.
2026-03-09T19:14:30

b.
2026-03-09T19:15:30

c.
2026-03-08T19:14:30

d.
2026-03-09T18:14:30
Question 4
Incorrect
Mark 0.00 out of 1.00
Flag question
Question text
import java.time.*;



public class Test {

    public static void main(String[] args) {

        LocalDateTime dt = LocalDateTime.now();

        dt.plusDays(10);

        System.out.println(dt.getDayOfMonth());

    }

}

Which statement is correct?



Question 4Answer

a.
Prints nothing

b.
Compilation error due to immutability

c.
Prints current system date

d.
Prints day after adding 10 days

e.
Runtime exception
Question 5
Incorrect
Mark 0.00 out of 1.00
Flag question
Question text
 Analyze the following code:

import java.util.*;

class DemoRemove {

  public static void main(String args[]) {

    String[] names = {"one", "two", "three"};

    List<String> list = Arrays.asList(names);

    list.set(1, "TWO");

    System.out.println(list);

    list.remove(0);

    System.out.println(list);

  }

}



Question 5Answer

a.
Throws ArrayIndexOutOfBoundsException

b.
[one, TWO, three] 

Throws UnsupportedOperationException


c.
[one, TWO, three]

[one, three]


d.
[one, TWO, three]

[TWO, three]


e.
Compilation error
Question 6
Correct
Mark 1.00 out of 1.00
Flag question
Question text
import java.time.*;

public class Test {

    public static void main(String[] args) {

        LocalDateTime dt =

            LocalDateTime.of(2027, Month.APRIL, 5, 6, 15, 30, 0);

        System.out.println(dt);

    }

}

What is the output?

Question 6Answer

a.
2027-04-05T06:15:30.000000000

b.
2027/04/05T06:15:30

c.
2027-04-05T06:15:30

d.
2027-04-05 06:15:30
Question 7
Correct
Mark 1.00 out of 1.00
Flag question
Question text
import java.time.*;

class Test{

  public static void main(String[] args) {

    LocalDate start = LocalDate.of(2015, Month.JANUARY, 5);

    LocalDate end = LocalDate.of(2015, Month.MARCH, 5);

    Period period = Period.ofWeeks(2);



    sendAlerts(start, end, period);

    System.out.println("start " + start);

  }



  private static void sendAlerts(LocalDate start,

    LocalDate end, Period period)

  {

    while (start.isBefore(end)) {

      System.out.println("Reminder " + start);

      start = start.plus(period);

    }

  }

}

How many times is Reminder printed?

Question 7Answer

a.
5

b.
6

c.
3

d.
4
Question 8
Correct
Mark 1.00 out of 1.00
Flag question
Question text
public class Test {

  public static void main(String[] args) {

    Integer i = 20;

    Integer j = i;

    i += 5;

    j -= 10;

    System.out.println(i + " " + j);

  }

}

What is the output?



Question 8Answer

a.
25 10

b.
25 15

c.
20 20

d.
15 15
Question 9
Correct
Mark 1.00 out of 1.00
Flag question
Question text
Consider the following code:

import java.util.*;

class TypeTest {

  public static void main(String args[]) {

    List<String> data = new ArrayList<>();

    data.add("A");

    data.add("B");

    Object[] objArr = data.toArray();

    String[] strArr = (String[]) objArr;

    System.out.println(strArr.length);

  }

}

What happens when this program is executed?



Question 9Answer

a.
Throws ClassCastException

b.
Prints 2

c.
Prints 0

d.
ArrayStoreException

e.
Compilation error
Question 10
Incorrect
Mark 0.00 out of 1.00
Flag question
Question text
import java.time.*;

public class Test {

    public static void main(String[] args) {

        LocalDate d = LocalDate.now();

        d = d.plusDays(2).plusMinutes(30);

        System.out.println(d);

    }

}

What happens when this code runs?

Question 10Answer

a.
Date increases by 2 days and 30 minutes

b.
Date remains unchanged

c.
None


d.
Exception is thrown before printing

e.
Date increases by only 2 days
Question 11
Correct
Mark 1.00 out of 1.00
Flag question
Question text
class Test {

  public static void main(String[] args) {

    Double d = 5.0;

    Integer i = 5;

    System.out.println(d.equals(i));

    System.out.println(d == 5.0);

  }

}

What is the output?

Question 11Answer

a.
false

false




b.
true

false


c.
true

true


d.
false

true

Question 12
Correct
Mark 1.00 out of 1.00
Flag question
Question text
import java.time.*;

public class Test {

    public static void main(String[] args) {

        LocalDate d = LocalDate.of(2026, 8, 29);

        d = d.plusYears(1);

        System.out.println(d);

    }

}

What is printed?

Question 12Answer

a.
2027-08-28

b.
2026-09-01

c.
2027-09-01

d.
2027-08-29
Question 13
Correct
Mark 1.00 out of 1.00
Flag question
Question text
import java.time.*;

public class Test {

    public static void main(String[] args) {

        LocalDate d = LocalDate.of(2026, Month.FEBRUARY, 25);

        System.out.println(d);

    }

}

What is the output?

Question 13Answer

a.
Compilation error

b.
2026-02-26

c.
Runtime exception

d.
2026-02-25

Question 14
Correct
Mark 1.00 out of 1.00
Flag question
Question text
import java.time.*;

class Test {

  public static void main(String[] args) {

    LocalDate d1 = LocalDate.of(2027, 1, 5);

    LocalDate d2 = LocalDate.of(2027, 1, 5);

    LocalDate d3 = LocalDate.of(2027, 1, 6);



    System.out.println(d1.isAfter(d2));

    System.out.println(dfalse1.isBefore(d3));

    System.out.println(d2.isBefore(d1));

  }

}

What is the output?

Question 14Answer

a.
true

false

true


b.
false

true

false


c.
false

false

true


d.
true

true

false

Question 15
Correct
Mark 1.00 out of 1.00
Flag question
Question text
import java.time.*;

import java.time.format.*;

class Test {

  public static void main(String[] args) {

    LocalDateTime dt = LocalDateTime.of(2025, 2, 25, 10, 30);

    DateTimeFormatter f =

      DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);

    System.out.println(f.format(dt));

    System.out.println(dt.format(f));

  }

}

Which statement is correct about the output?



Question 15Answer

a.
Both lines print the same localized date only


b.
First prints date, second prints date and time


c.
Order of format calls changes the result


d.
Both lines print localized date and time

