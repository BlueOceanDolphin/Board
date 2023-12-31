package org.myBoard.board.commons.rests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class JSONData<T> {
    private boolean success;
    private HttpStatus status = HttpStatus.OK; // 200코드가 가장 많으므로 200
    private String message;
    private T data;
}
