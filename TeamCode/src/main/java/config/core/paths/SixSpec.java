package config.core.paths;

import android.graphics.Path;

import com.pedropathing.commands.HoldPoint;
import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.BezierCurve;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.PathBuilder;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.pathgen.Point;

public class SixSpec {

    public static Pose start = new Pose(8, 66, Math.toRadians(0));
    public static Pose score1 = new Pose(37.75, 66, Math.toRadians(0));
    public static Pose sub2 = new Pose(25, 66, Math.toRadians(0)); // 48 + 2.5 - 18.5 - 7
    public static Pose deposit2 = new Pose(40,40, Math.toRadians(225));
    public static Pose grab2 = new Pose(7, 36, Math.toRadians(180));
    public static Pose score2 = new Pose(42, 76, Math.toRadians(180));
    public static Pose grab3 = new Pose(7.75, 36, Math.toRadians(180));
    public static Pose score3 = new Pose(42, 75, Math.toRadians(180));
    public static Pose grab4 = new Pose(7.75, 36, Math.toRadians(180));
    public static Pose score4 = new Pose(42, 73, Math.toRadians(180));
    public static Pose grab5 = new Pose(7.75, 36, Math.toRadians(180));
    public static Pose score5 = new Pose(42, 71, Math.toRadians(180));
    public static Pose grab6 = new Pose(8, 36, Math.toRadians(180));
    public static Pose score6 = new Pose(7.5, 123, Math.toRadians(270));
    public static Pose park = new Pose(9, 40, Math.toRadians(270));

    public static PathChain score1() {
        return new PathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(start),
                                new Point(score1)
                        )
                )
                .setConstantHeadingInterpolation(start.getHeading())
                .setZeroPowerAccelerationMultiplier(3)
                .build();
    }

    public static PathChain sub2() {
        return new PathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(score1),
                                new Point(sub2)
                        )
                )
                .setConstantHeadingInterpolation(start.getHeading())
                .setZeroPowerAccelerationMultiplier(3)
                .build();

    }

    public static PathChain deposit2() {
        return new PathBuilder()
                .addPath(new BezierCurve(sub2, new Pose(sub2.getX() - 10, sub2.getY() + 10), deposit2))
                .setLinearHeadingInterpolation(sub2.getHeading(), deposit2.getHeading())
                .setZeroPowerAccelerationMultiplier(4)
                .build();
    }

    public static PathChain push() {
        return new PathBuilder()
                .addPath(
                        new BezierCurve(
                                new Point(deposit2),
                                new Point(20.000, 17.000, Point.CARTESIAN),
                                new Point(66.500, 44.000, Point.CARTESIAN),
                                new Point(52.5, 24.000, Point.CARTESIAN)
                        )
                )
                .setLinearHeadingInterpolation(deposit2.getHeading(), Math.toRadians(180))
                .addPath(
                        new BezierLine(
                                new Point(52.5, 24.000, Point.CARTESIAN),
                                new Point(28.000, 24.000, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(180))
                .addPath(
                        new BezierCurve(
                                new Point(28.000, 24.000, Point.CARTESIAN),
                                new Point(70.000, 24.000, Point.CARTESIAN),
                                new Point(52.5, 15.000, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(180))
                .addPath(
                        new BezierLine(
                                new Point(52.5, 14.000, Point.CARTESIAN),
                                new Point(28.000, 15.000, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(180))
                .addPath(
                        new BezierCurve(
                                new Point(28.000, 15.000, Point.CARTESIAN),
                                new Point(65.000, 21.000, Point.CARTESIAN),
                                new Point(52.5, 9.5, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(180))
                .addPath(
                        new BezierLine(
                                new Point(52.5, 9.5, Point.CARTESIAN),
                                new Point(20, 9.5, Point.CARTESIAN)
                        )
                )
                .setZeroPowerAccelerationMultiplier(6)
                .setConstantHeadingInterpolation(Math.toRadians(180))
                .build();
    }

    public static PathChain grab2() {
        return new PathBuilder()
                .addPath(
                        new BezierCurve(
                                new Point(20, 9, Point.CARTESIAN),
                                new Point(36, 36, Point.CARTESIAN),
                                new Point(grab2)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(180))
                .setZeroPowerAccelerationMultiplier(2)
                .build();
    }

    public static PathChain score2() {
        return new PathBuilder()
                .addPath(
                        new BezierLine(
                                grab2,
                                score2
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(180))
                .build();
    }

    public static PathChain grab3() {
        return new PathBuilder()
                .addPath(
                        new BezierLine(
                                score2,
                                grab3
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(180))
                .setZeroPowerAccelerationMultiplier(2)
                .build();
    }

    public static PathChain score3() {
        return new PathBuilder()
                .addPath(
                        new BezierLine(
                                grab3,
                                score3
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(180))
                .build();
    }

    public static PathChain grab4() {
        return new PathBuilder()
                .addPath(
                        new BezierLine(
                                score3,
                                grab4
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(180))
                .setZeroPowerAccelerationMultiplier(2)
                .build();
    }

    public static PathChain score4() {
        return new PathBuilder()
                .addPath(
                        new BezierLine(
                                grab4,
                                score4
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(180))
                .build();
    }

    public static PathChain grab5() {
        return new PathBuilder()
                .addPath(
                        new BezierLine(
                                score4,
                                grab5
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(180))
                .setZeroPowerAccelerationMultiplier(2)
                .build();
    }

    public static PathChain score5() {
        return new PathBuilder()
                .addPath(
                        new BezierLine(
                                grab5,
                                score5
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(180))
                .build();
    }

    public static PathChain grab6() {
        return new PathBuilder()
                .addPath(
                        new BezierLine(
                                score5,
                                grab6
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(180))
                .setZeroPowerAccelerationMultiplier(2)
                .build();
    }

    public static PathChain score6() {
        return new PathBuilder()
                .addPath(
                        new BezierCurve(
                                grab6,
                                new Pose(32.000, 70.500),
                                score6
                        )
                )
                .setZeroPowerAccelerationMultiplier(4)
                .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(270), 0.3)
                .build();
    }

    public static PathChain park() {
        return new PathBuilder()
                .addPath(
                        new BezierLine(
                                score6,
                                park
                        )
                )
                .setTangentHeadingInterpolation()
                .setZeroPowerAccelerationMultiplier(7)
                .build();
    }
}


