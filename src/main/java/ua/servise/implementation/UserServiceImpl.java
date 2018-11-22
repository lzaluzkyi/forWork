package ua.servise.implementation;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.entity.UserEntity;
import ua.mapper.UserMapper;
import ua.repository.UserEntityRepository;
import ua.servise.UserService;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserEntityRepository repository;

    private final PasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserEntityRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public void save(UserEntity entity) {
        entity.setPassword(encoder.encode(entity.getPassword()));
        repository.save(entity);
    }
    
    @Override
    public void update(UserEntity entity) {
        repository.save(entity);
    }


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity entity = repository.findForAuth(login);
        if(entity==null) throw new UsernameNotFoundException("User with "+login+" not found");
        return UserMapper.toUser(entity);
    }

	@Override
	public UserEntity findByEmail(String email) {
		
		UserEntity entity = repository.findByEmail(email);
		
		
		return entity ;
	}

	@Override
	public List<UserEntity> findAll() {
		List<UserEntity> users = repository.findAll();

		return users;
	}

	@Override
	public UserEntity findOne(Integer id) {
	return repository.findById(id).orElse(null);
	}

	@Override
	public void createExsel(Integer id) {
		UserEntity user = findOne(id);
		
		 Workbook workbook = new XSSFWorkbook();
	        Sheet sheetAllInf = workbook.createSheet("Inf");
	        
	        Row rowForExsel = sheetAllInf.createRow(0);
	        rowForExsel.createCell(0).setCellValue("F Name");
	        rowForExsel.createCell(1).setCellValue("S Aame");
	        rowForExsel.createCell(2).setCellValue("Phone");
	        rowForExsel.createCell(3).setCellValue("E - mail");
	        sheetAllInf.createRow(1);
	        rowForExsel.createCell(0).setCellValue(user.getFirstName());
	        rowForExsel.createCell(1).setCellValue(user.getSecondName());
	        rowForExsel.createCell(2).setCellValue(user.getPhone());
	        rowForExsel.createCell(3).setCellValue(user.getEmail());
	        
	        try {
	            FileOutputStream outputStream = new FileOutputStream(
	                    "C:/forwork/"  + " tableWihtInf " + ".xlsx");
	            workbook.write(outputStream);
	            outputStream.close();
	        }catch (Exception e){
	            e.printStackTrace();
	        }

	        
		
	}

}
