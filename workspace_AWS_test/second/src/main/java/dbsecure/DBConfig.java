package dbsecure;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@Configuration //내가 설정 클래스입니다
@EnableEncryptableProperties //현재 정보를 application.properties파일에서 사용 가능 
public class DBConfig {
	@Bean("jasyptEncryptor") //메소드 리턴 객체 주입
	public StringEncryptor  stringEncryptor(){
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(System.getenv("DB_PASSWORD"));
        config.setAlgorithm("PBEWithMD5AndDES"); // 알고리즘
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        System.out.println("===DBConfig 출력===");
        System.out.println(System.getenv("DB_PASSWORD"));
        System.out.println
        (encryptor.decrypt("xznG7JdUcYmS7FaulC2blkR7QFPPrHsaREza48uoZig="));
        System.out.println
        (encryptor.decrypt("9vDxpMxWTR6l2y+DZgxm+AC2tUACLeNwRdiKvZO9SjH16xl7mOzZ5zsK449nz8YVO0mp3ObaJBU+WdO0lyUSO0BzJerzFxmp1OIbsBxvpK3Z3C8ROWI6WMvF1kZd00+idlSCH1VynKA=")
        );
        System.out.println(encryptor.decrypt("xsBdVQUKzeJ+zGVR7NmF3a1XuaMndAsi"));
        System.out.println(encryptor.decrypt("O1cwrPE+nSv4DuDMHqfiS4GlRafI4+Vq"));
        

        return encryptor;
        
        
	}
}
