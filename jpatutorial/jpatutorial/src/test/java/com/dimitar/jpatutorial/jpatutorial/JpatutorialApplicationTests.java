package com.dimitar.jpatutorial.jpatutorial;

import com.dimitar.jpatutorial.jpatutorial.entities.*;
import com.dimitar.jpatutorial.jpatutorial.repos.*;
import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpatutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	PaymentRepository paymentRepository;


	@Autowired
	ProgrammerRepository programmerRepository;

	@Autowired
    LicenceRepository licenceRepository;

	@Autowired
	EntityManager entityManager;

	@Autowired
	BankAccountRepository bankAccountRepository;


	@Autowired
	ImageRepository imageRepository;

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	TrollRepository trollRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreate() {
		Product product = new Product();
		product.setId(1);
		product.setName("Iphone X");
		product.setDesc("Stupid Iphone");
		product.setPrice(1000d);

		final Product savedObject = (Product)productRepository.save(product);
		assert(savedObject != null);
	}

	@Test
	public void testRead(){
		Product product = new Product();
		product.setId(2);
		product.setName("Samsung 9");
		product.setDesc("Mobile phone");
		product.setPrice(1000d);

		final Product savedObject = (Product)productRepository.save(product);
		assert(savedObject != null);

		Optional<Product> optional = productRepository.findById(2);
		assert (optional.isPresent());
	}

	@Test
	public void testUpdate(){
		Product product = new Product();
		product.setId(3);
		product.setName("Xiaomi");
		product.setDesc("Mobile phone");
		product.setPrice(1000d);

		productRepository.save(product);

		Optional<Product> optional = productRepository.findById(3);
		assert (optional.isPresent());
		product = optional.get();
		product.setPrice(100d);
		productRepository.save(product);

		optional = productRepository.findById(3);
		product = optional.get();
		assert (product.getPrice() == 100d);
	}

	@Test
	public void testDelete(){
		Product product = new Product();
		product.setId(4);
		product.setName("Blue");
		product.setDesc("Mobile phone");
		product.setPrice(100d);

		productRepository.save(product);

		assert(productRepository.existsById(4));

		productRepository.deleteById(4);

		assert(!productRepository.existsById(4));
	}

	@Test
	public void testFindAllPaging(){
		Pageable pageable = PageRequest.of(2,4);

		System.out.println("----------------------------------------------------->>>>>>>>>>>>>>>");
		Page<Product> page = productRepository.findAll(pageable);
		page.forEach(p -> System.out.println(p.getDesc()));
	}

	@Test
	public void testFindAllSorting(){
		System.out.println("----------------------------------------------------->>>>>>>>>>>>>>>");
		productRepository.findAll(new Sort(Sort.Direction.ASC, "name", "price")).forEach(p -> System.out.println(p.getName()));


		//productRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "name"), new Sort.Order(Sort.Direction.DESC, "price"));

	}


	@Test
	public void testPagingAndSorting(){
		Pageable pageable = PageRequest.of(0,5, new Sort(Sort.Direction.ASC,"name"));
		System.out.println("----------------------------------------------------->>>>>>>>>>>>>>>");
		Page<Product> page = productRepository.findAll(pageable);
		page.forEach(p -> System.out.println(p.getDesc()));
	}


	@Test
	public void testStudentCreate(){
		Student student = new Student();
		student.setFirstName("Jean Luc");
		student.setLastName("Picard");
		student.setScore(90);

		studentRepository.save(student);

		student = new Student();
		student.setFirstName("Data");
		student.setLastName("Data");
		student.setScore(100);

		studentRepository.save(student);

		student = new Student();
		student.setFirstName("William");
		student.setLastName("Riker");
		student.setScore(90);

		studentRepository.save(student);
	}


    @Test
    public void tetsFindAllStudents() {
        Pageable pageable = PageRequest.of(0,5,new Sort(Sort.Direction.ASC, "firstName"));
		studentRepository.findAllStudents(pageable).forEach(s->System.out.println(s));
    }


    @Test
    public void tetsFindAllStudentsPartial(){
        studentRepository.findAllStudentsPartialData().forEach(s->System.out.println(s[0] + ", " + s[1]));
    }

    @Test
    public void tetsFindAllStudentsByFirstName(){
        studentRepository.findAllStudentsByFirstName("Jean Luc").forEach(s->System.out.println(s));
    }


    @Test
    public void tetsFindAllStudentsForGivenScores(){
        studentRepository.findAllStudentsForGivenScores(60,100).forEach(s->System.out.println(s));
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testDeleteStudentByFirstName() {
        studentRepository.deleteStudentsByFirstName("Data");
    }


    @Test
    public void tetsFindAllStudentsNQ() {
        Pageable pageable = PageRequest.of(0,5);
        studentRepository.findAllStudentsNQ().forEach(s->System.out.println(s));
    }

    @Test
    public void tetsFindByFirstNameNQ() {
        Pageable pageable = PageRequest.of(0,5);
        studentRepository.findAllByFirstNameNQ("Jean Luc").forEach(s->System.out.println(s));
    }


    @Test
    public void testCreatePayment() {
        CreditCard cc = new CreditCard();
        cc.setId(324);
        cc.setAmount(1000);
        cc.setCardnumber("12345678");
        paymentRepository.save(cc);
    }

    @Test
    public void testCreateCheckPayment() {
        Check cc = new Check();
        cc.setId(324);
        cc.setAmount(1000);
        cc.setChecknumber("444555");
        paymentRepository.save(cc);
    }



	@Test
	public void testCustomerWithAddressCreate() {
		Customer customer = new Customer();

		customer.setName("Jean Luc Picard");

		PhoneNumber number = new PhoneNumber();
		number.setNumber("+1889889889");
		number.setType("Ship");

		PhoneNumber number2 = new PhoneNumber();
		number2.setNumber("+1821212121");
		number2.setType("Earth");

		customer.addPhoneNumber(number);
		customer.addPhoneNumber(number2);

		customerRepository.save(customer);
	}

	@Test
	@Transactional
	public void testLoadCustomer() {
		final Optional<Customer> optCustomer = customerRepository.findById(69l);
		final Customer customer = optCustomer.get();

		final Set<PhoneNumber> numbers =  customer.getNumbers();
		numbers.forEach(n->System.out.println("---------> " + n.getNumber()));
	}


    @Test
    public void testCreateProgrammer() {
        Programmer programmer = new Programmer();
        programmer.setName("Dimitar");
        programmer.setSalary(20000);

        Project project = new Project();
        project.setName("Long term project");


        programmer.addProject(project);

        programmerRepository.save(programmer);
    }


    @Test
    public void testLicence() {
        Person person = new Person();
        person.setAge(34);
        person.setFirstName("Dimitar");
        person.setLastName("Rich :)");

        Licence licence = new Licence();
        licence.setType("Drivers Licence");
        licence.setValidFrom(new Date());
        licence.setValidTo(new Date());

        licence.setPerson(person);

        licenceRepository.save(licence);
    }


    @Test
    public void testDeleteLicence() {
        Optional<Licence> licence = licenceRepository.findById(82L);

        licenceRepository.delete(licence.get());
    }


    @Test
	@Transactional
	public void testCaching() {
    	Session session = entityManager.unwrap(Session.class);

    	Optional<Product> optional = productRepository.findById(20);
    	Product product = optional.get();


		productRepository.findById(20);
		session.evict(product);

		productRepository.findById(20);
	}



	@Test
	@Transactional
	public void testBankAccount() {
		BankAccount first = bankAccountRepository.findById(1).get();

		System.out.println("---------------------------------------------------------------------------");
		System.out.println("first name: " + first.getFirstName() + " ,last name: " + first.getLastName());
	}


	@Test
	public void testImageSave() throws Exception{

    	Image image = new Image();
    	image.setId(1);
    	image.setName("Test image");

    	File file = new File("C:\\lotr.jpg");
		FileInputStream inputStream = new FileInputStream(file);
		byte [] content = new byte[(int)file.length()];
		inputStream.read(content);
		image.setData(content);



		imageRepository.save(image);
		inputStream.close();
	}


	@Test
	public void testReadImage() throws Exception{
    	Image image = imageRepository.findById(1).get();

    	File file = new File("C:\\tolkien_from_DB.jpg");
    	FileOutputStream fos = new FileOutputStream(file);
		fos.write(image.getData());

		fos.close();
	}


	@Test
	public void testCreateTroll() {
		Troll troll = new Troll();

		troll.setFirstName("TROLINJO");
		troll.setLastName("TROLINOVIC");
		troll.setTheAddress("Trollovi gornji");


		trollRepository.save(troll);
	}
}
