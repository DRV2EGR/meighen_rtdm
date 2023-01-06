package io.meighen.presenter.service;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

import com.sun.xml.bind.v2.model.core.PropertyInfo;
import org.springframework.stereotype.Service;

@Service
public class UpdateObjectsService {
    private static void SetPropValue(Object obj, String field, String value) throws NoSuchFieldException {
        Field privateField = obj.getClass().getDeclaredField(field);
        privateField.setAccessible(true);

//        ConcreteClass objTest = new ConcreteClass(1);
//        System.out.println(privateField.get(objTest)); // prints "private string"
//        privateField.set(objTest, "private string updated");
//        System.out.println(privateField.get(objTest)); //prints "private string updated"
    }
}
