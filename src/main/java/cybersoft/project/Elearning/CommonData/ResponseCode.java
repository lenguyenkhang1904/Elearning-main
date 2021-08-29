package cybersoft.project.Elearning.CommonData;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.asm.Advice.This;

@Getter
@Setter
public class ResponseCode {
		
		
	public static int getRandomInt(int min, int max) {
		Random random = new Random();

		return random.nextInt((max - min) + 1) + min;
	}

	public static String generateCode() {
		
		 
		
		UUID uuid = UUID.randomUUID();

		return uuid.toString() ;

	}
	
		
}
