package models.book;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AddBookRequest {
    private String userId;
    private List<IsbnBook> collectionOfIsbns;
}
