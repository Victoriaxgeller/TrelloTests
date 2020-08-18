package api;

import retrofit2.Call;
import retrofit2.http.*;

public interface TrelloAPI {

    String BOARD = "1/boards/";
    String BOARD_BY_ID = "1/boards/{id}";

    @POST(BOARD)
    Call<Board> createBoard(@Body Board board);

    @PUT(BOARD_BY_ID)
    Call<Board> updateBoard(@Body Board board, @Path("id") String id);

    @GET(BOARD_BY_ID)
    Call<Board> requestBoard(@Path("id") String id, @Query("key") String key, @Query("token") String token);

    @DELETE(BOARD_BY_ID)
    Call<Board> removeBoard(@Path("id") String id, @Query("key") String key, @Query("token") String token);
}
