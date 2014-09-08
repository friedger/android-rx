package be.cegeka.android.rx.service;


import be.cegeka.android.rx.domain.Board;
import be.cegeka.android.rx.domain.Game;
import be.cegeka.android.rx.infrastructure.PixelConverter;
import be.cegeka.android.rx.infrastructure.RotationSensor;
import rx.Observable;
import rx.Subscriber;

public class GameService {

    private Board board;
    private RotationSensor rotationSensor;
    private PixelConverter pixelConverter;

    public GameService(Board board, RotationSensor rotationSensor, PixelConverter pixelConverter) {
        this.board = board;
        this.rotationSensor = rotationSensor;
        this.pixelConverter = pixelConverter;
    }

    public Observable<Game> createNewGame() {
        return Observable.create(new Observable.OnSubscribe<Game>() {
            @Override
            public void call(Subscriber<? super Game> subscriber) {
                subscriber.onNext(new Game(board, rotationSensor, pixelConverter));
                subscriber.onCompleted();
            }
        });
    }

}
