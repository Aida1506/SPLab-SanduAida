package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import difexamples.ClientComponent;
import difexamples.SingletonComponent;
import difexamples.TransientComponent;

@SpringBootApplication(scanBasePackages = {"com.example.demo", "difexamples"})
public class DemoApplication {

    public static void main(String[] args) {
        //SpringApplication.run(DemoApplication.class, args);

        //
        // Run the main function and inspect the output in console
        // to learn about the lifecycle of objects within the
        // Spring Dependency Injection Context
        //
        // Gets a handle of dependency injection context
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        // Gets an instance of TransientComponent from the DI context
        TransientComponent transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();

        // Note that every time an instance is required, the DI context creates a new one
        transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();

        // Gets an instance of SingletonComponent from the DI context
        // Note that the unique instance was created while application was loaded, before creating the transient instances
        SingletonComponent singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();

        // Note that every time an instance is required, the DI returns the same unique one
        singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();
        // Gets an instance of another class that requires singleton/transient components
        // Note where this instance was created and what beans were used to initialize it
        ClientComponent c = context.getBean(ClientComponent.class);
        c.operation();

        // One can also request an instance from DI context by name
        c = (ClientComponent)context.getBean("clientComponent");
        c.operation();

        Book noapteBuna = new Book("Noapte Buna, copii!");
        Author rpGheo = new Author("Radu Pavel Gheo");
        noapteBuna.addAuthor(rpGheo);

        Section cap1 = new Section("Cap1");
        Section cap11 = new Section("Cap1.1");
        Section cap111 = new Section("Cap1.1.1");
        Section cap1111 = new Section("Subchapter 1.1.1.1");
        noapteBuna.addElement(new Paragraph("Multumesc celor care..."));
        noapteBuna.addElement(cap1);
        cap1.add(new Paragraph("Moto capitol"));
        cap1.add(cap11);
        cap11.add(new Paragraph("Text from subchapter 1.1"));
        cap11.add(cap111);
        cap111.add(new Paragraph("Text from subchapter 1.1.1"));
        cap111.add(cap1111);
        cap1111.add(new Image("Image subchapter 1.1.1.1"));

        noapteBuna.print();
    }

}
