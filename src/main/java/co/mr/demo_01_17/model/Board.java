package co.mr.demo_01_17.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Board 테이블과 연동되는 모델클래스라는 것을 알려주는 어노테이션
@Entity
@Data
public class Board {
    @Id // pk라는 것을 알려주기 위해
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // SEQUENCE가 성능이 가장 좋다고 함. IDENTITY가 가장 많이 사용, TABLE 성능이 제일 안좋음
    private long id;
    private String title;
    private String contents;
}
