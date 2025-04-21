package com.crio.coderhack.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import com.crio.coderhack.dto.Badge;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Document(collection = "users")
public class UserEntity {
    @Id
    private String userId;
    private String username;
    private int score;
    private List<Badge> badges = new ArrayList<>();
}
