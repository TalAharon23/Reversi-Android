package com.dsaptal.reversi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;


public class GameView extends View {
    public static Context context;
    Paint paint;
    GameService game;
    public static Point size = new Point();
    Ai ai = GameService.get_instance().ai;
    Player player = GameService.get_instance().player;
    Canvas canvas;
    ArrayList<Piece> availablePoss;


    public GameView(Context context,AttributeSet attr) {
        super(context, attr);
        this.context = context;
        canvas=new Canvas();
        paint = new Paint();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        display.getSize(size);
    }
    public void RestartTimer() {
        new CountDownTimer(3500, 1000) {
            public void onTick(long millisUntilFinished) {
                final Toast toast = Toast.makeText(context, "restarting in: " + millisUntilFinished / 1000, Toast.LENGTH_LONG);
                toast.show();
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        toast.cancel();
                    }
                }, 1000);
            }
            public void onFinish() {

            }
        }.start();
    }

    public boolean onTouchEvent( MotionEvent event ) {
        if (event.getAction() != MotionEvent.ACTION_UP)
            return true;

        game = GameService.get_instance();
        if (GameService.get_instance().turn == 0) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            Piece p = game.RectContain(x, y);
            availablePoss = Rules.get_instance().IsPossible(this.player);
            if (p != null && availablePoss.contains(p))
                if (Rules.get_instance().LegalMove(p)) {
                    game.PutPiece(this.player, p, SideTypes.BLACK);
                } else {
                    Toast toast = Toast.makeText(context, "Illigal Move", Toast.LENGTH_LONG);
                    toast.show();
                }
        }

        if (game.turn == 1) {
            ai.MakeaMove();
        }
        return true;

    }
    protected void onDraw(Canvas canvas) {
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        GameService.get_instance().onDraw(canvas,paint);
    }
}
