package cybersoft.project.Elearning.Ultils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;



@Component
public class MapModelToDto<E extends Object,T extends Object> {
		
		public T MapToDto(E dto,T model)
		{
			Method[] methodDto=dto.getClass().getMethods();
			
			List<String> dtoGetter=new LinkedList<String>();
			
			for(Method method:methodDto)
			{
				if(!method.getName().equals("getClass") && method.getName().startsWith("get"))
					dtoGetter.add(method.getName());
			}
			
			for (String getter : dtoGetter) {
				
				try {
					Object valuedtoObject=dto.getClass().getMethod(getter).invoke(dto);
					
					String modelSetter=getter.replace("get","set");
					
					Class<?> property=model.getClass().getMethod(modelSetter,valuedtoObject.getClass()).getParameterTypes()[0];
					
					model.getClass().getMethod(modelSetter,property).invoke(model,property.cast(valuedtoObject));
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return model;
		}
	
}
