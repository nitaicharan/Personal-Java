package personalspring.application.use_cases.base;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Arrays;
import personalspring.domain.models.BaseModel;

public abstract class BaseUsecase<Model extends BaseModel> {

  public void transferProperties(Object source, Model model) {
    try {
      PropertyDescriptor[] propertyDescriptors =
          Introspector.getBeanInfo(source.getClass()).getPropertyDescriptors();

      // Get the property descriptors for the model class
      PropertyDescriptor[] modelPropertyDescriptors =
          Introspector.getBeanInfo(model.getClass()).getPropertyDescriptors();

      for (PropertyDescriptor objProp : propertyDescriptors) {
        // Get the corresponding PropertyDescriptor from model class
        PropertyDescriptor modelProp =
            Arrays.stream(modelPropertyDescriptors)
                .filter(pd -> pd.getName().equals(objProp.getName()))
                .findFirst()
                .orElse(null);

        if (modelProp != null) {
          Method objGetter = objProp.getReadMethod();
          Method modelSetter = modelProp.getWriteMethod();

          // Check if both getter and setter exist
          if (objGetter != null && modelSetter != null) {
            // Invoke the getter method on obj to get the value
            Object value = objGetter.invoke(source);

            // Invoke the setter method on model to set the value
            modelSetter.invoke(model, value);
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
