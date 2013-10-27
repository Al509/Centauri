package centauri.ui;

import javafx.scene.paint.Color;

public class ArcPieceBuilder {
    private Color strokeColor;
    private double strokeWidth;
    private double x;
    private double y;
    private double w;
    private double pixelsToMove;
    private long displayTimePerFrameMillis;
    private double startExtent;
    private double startAngle;
    private double h;

    public static ArcPieceBuilder create() {
        return new ArcPieceBuilder();
    }

    public ArcPieceBuilder strokeColor(Color longPieceColor) {
        this.strokeColor =  longPieceColor;
        return this;
    }
    public ArcPieceBuilder strokeWidth(int v){
        strokeWidth = v;
        return this;
    }

    public ArcPieceBuilder x(double x) {
        this.x = x;
        return this;
    }

    public ArcPieceBuilder y(double y) {
        this.y = y;
        return this;
    }

    public ArcPieceBuilder w(double w) {
        this.w = w;
        return this;
    }

    public ArcPieceBuilder h(double h) {
        this.h = h;
        return this;
    }

    public ArcPieceBuilder startAngle(double h) {
        this.startAngle = h;
        return this;
    }

    public ArcPieceBuilder arcExtent(double h) {
        this.startExtent = h;
        return this;
    }

    public ArcPieceBuilder displayTimePerFrameMillis(long h) {
        this.displayTimePerFrameMillis = h;
        return this;
    }

    public ArcPieceBuilder pixelsToMove(double h) {
        this.pixelsToMove = h;
        return this;
    }


    public ArcPiece build() {
        ArcPiece arc = new ArcPiece();
        arc.strokeColor = strokeColor;
        arc.strokeWidth = strokeWidth;
        arc.x = x;
        arc.y = y;
        arc.w = w;
        arc.pixelsToMove = pixelsToMove;
        arc.displayTimePerFrameMillis = displayTimePerFrameMillis;
        arc.arcExtent = startExtent;
        arc.startAngle = startAngle;
        arc.h = h;
        return arc;
    }

}
