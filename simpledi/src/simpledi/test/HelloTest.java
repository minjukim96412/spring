package simpledi.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import simpledi.bean.Hello;
import simpledi.service.Printer;

public class HelloTest {
	
		public static void main(String[] args) {
			
			// BeanFactory�� ��ӹ��� ApplicationContext�� ����
			// conf/beans.xml(�� ���� ����)�� �о ApplicationContext�� ����
			ApplicationContext context =
					new GenericXmlApplicationContext("conf/beans.xml");
			
			// hello��� id�� ���� ���� ã�Ƽ� Hello ��ü ����
			Hello hello = (Hello)context.getBean("hello");
			System.out.println(hello);
			
			Hello hello2 = (Hello)context.getBean("hello");
			// �� ��ü�� ���� ��ü, Ư���� ������ ���� ������ �������� ��ü��
			// ��Ŭ��(Ŭ�������� ��ü�� �ϳ��� �����ϴ� ����)���� ����
			// �� �����ÿ� scope="prototype"���� �ϸ� ��ü �����ø��� �ٸ� ��ü�� ������ ��
			System.out.println(hello==hello2); 

			// stringPrinter��� id�� ���� ���� ã�Ƽ� StringPrinter ��ü�� ����
			Printer stringPrinter = (Printer)context.getBean("stringPrinter");
			stringPrinter.print("stringPrinter");
			System.out.println(stringPrinter.toString());
			
			// consolePrinter��� id�� ���� ���� ã�Ƽ� ConsolePrinter ��ü�� ����			
			Printer consolePrinter = (Printer)context.getBean("consolePrinter");
			consolePrinter.print("consolePrinter");
			
		} // main

} // class











