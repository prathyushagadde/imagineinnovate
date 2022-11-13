package imagineinnovate.springboot.exception;

import java.util.HashMap;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
	
@RestControllerAdvice
public class ApplicationExceptionHandler extends RuntimeException{
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public HashMap<String, String> handleInvalidAurgument(MethodArgumentNotValidException ex){
		HashMap<String, String> errorMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElement(NoSuchElementException ex1){
		return new ResponseEntity<String>("No such Id present in DB", HttpStatus.BAD_REQUEST);
		
	}
}
	