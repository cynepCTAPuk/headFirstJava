package stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapTest {
	@Test
	public void mapInt() {
		List<Integer> numbers = Arrays.asList(1, 3, 5, 7);
		String collect = numbers.stream().map(i -> String.valueOf(i * 2)).collect(Collectors.joining(", "));
		System.out.println(collect);
	}

	@Test
	public void mapString() {
		List<String> names = Arrays.asList("john", "arya", "sansa");
		String collect = names.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
		System.out.println(collect);
	}

	@Test
	public void objectToString() {
		List<Car> cars = Arrays.asList(
				new Car("AA1111BX", 2007),
				new Car("AM1111BE", 2009),
				new Car("AK5555IT", 2010),
				new Car("AI5601CC", 2015),
				new Car("AI3838PP", 2017));
		String collect = cars.stream()
				.map(Car::getNumber) // преобразовываем Stream машин в Stream номеров
				.collect(Collectors.joining(", "));
		System.out.println(collect);
	}

	@Test
	public void filterMap() {
		List<Car> cars = Arrays.asList(
				new Car("AA1111BX", 2007),
				new Car("AK5555IT", 2010),
				new Car(null, 2012),
				new Car("", 2015),
				new Car("AI3838PP", 2017));
		String collect = cars.stream()
				.filter(c -> c.getYear() > 2009) // выбираем только машины, выпущенные после 2010 года
				.map(Car::getNumber) // преобразовываем Машины в номера, теперь у нас Stream номеров машин
				.filter(s -> s != null && !s.isEmpty()) // выбираем только не пустые номера
				.collect(Collectors.joining(", "));
		System.out.println(collect);
	}

	@Test
	public void objectToObject() {
		List<Staff> staffList = Arrays.asList(
				new Staff("mkyong", 30, new BigDecimal(10000)),
				new Staff("jack", 27, new BigDecimal(20000)),
				new Staff("lawrence", 33, new BigDecimal(30000)));
		System.out.println(staffList);

		List<StaffPublic> staffPublicList = staffList.stream()
				.map(a -> {
					StaffPublic staffPublic = new StaffPublic();
					staffPublic.setName(a.getName());
					staffPublic.setAge(a.getAge());
					if ("mkyong".equals(a.getName())) staffPublic.setExtra("this field is for mkyong only!");
					return staffPublic;
				})
				.toList();
		System.out.println(staffPublicList);
	}
}

@Getter
@AllArgsConstructor
class Car {
	private final String number;
	private final int year;
}

@Getter
@AllArgsConstructor
@ToString
class Staff {
	private String name;
	private int age;
	private BigDecimal salary;
}

@Setter
@ToString
class StaffPublic {
	private String name;
	private int age;
	private String extra;
}