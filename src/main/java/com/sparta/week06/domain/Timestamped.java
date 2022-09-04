package com.sparta.week06.domain;

import lombok.Getter;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 상속했을 때 컬럼으로 인식하게 함
@EntityListeners(AutoCloseable.class) // 수정 시간 자동으로 반영
public class Timestamped {

    @LastModifiedDate
    private LocalDateTime modifiedAt;

}
