/*
MIT License
Copyright (c) 2018 DarBots Collaborators
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package org.firstinspires.ftc.teamcode.DarlingtonSharedLib.Sensors;
import org.firstinspires.ftc.teamcode.DarlingtonSharedLib.Calculations.XYPlaneCalculations;
public class RobotWheel {
    private double m_wheelRadius;
    private double m_wheelInstalledAngle;
    protected static double calculateRotation(double Angle){ // -180 <= Angle < 180
        return XYPlaneCalculations.normalizeDeg(Angle);
    }
    public RobotWheel(double Radius, double InstalledAngle){
        this.m_wheelRadius = Radius;
        this.setInstalledAngle(InstalledAngle);
    }
    public double getRadius(){
        return this.m_wheelRadius;
    }
    public void setRadius(double newRadius){
        this.m_wheelRadius = newRadius;
    }
    public double getInstalledAngle(){
        return this.m_wheelInstalledAngle;
    }
    public void setInstalledAngle(double newInstalledAngle){
        this.m_wheelInstalledAngle = this.calculateRotation(newInstalledAngle);
    }
    public double getPerimeter(){
        return (2 * Math.PI * m_wheelRadius);
    }
    public double getArcLength(double AngleInDegree){
        return (AngleInDegree / 360 * this.getPerimeter());
    }
    public double[] getRobotAxisForDistance(double distance){
        double[] mResult = new double[2];
        mResult[0] = Math.cos(-Math.toRadians(this.m_wheelInstalledAngle)) * distance;
        mResult[1] = Math.sin(-Math.toRadians(this.m_wheelInstalledAngle)) * distance;
        return mResult;
    }
    public double[] getRobotAxisPerCycle(){
        double distance = this.getPerimeter();
        return getRobotAxisForDistance(distance);
    }
    public double[] getRobotAxisForAngle(double RotatedAngleInDegree){
        double distance = this.getArcLength(RotatedAngleInDegree);
        return getRobotAxisForDistance(distance);
    }
    public double calculateCycleForDistance(double Distance){
        return (Distance / this.getPerimeter());
    }
    public double calculateDistanceByRobotAxisX(double X) throws RuntimeException{
        if(this.m_wheelInstalledAngle == 90 || this.m_wheelInstalledAngle == -90){
            throw new RuntimeException("You cannot move through RobotX Axis because the installed angle is vertical");
        }
        double Rst = X / this.getXPerDistance();
        return Rst;
    }
    public double calculateDistanceByRobotAxisY(double Y) throws RuntimeException{
        if(this.m_wheelInstalledAngle == -180 || this.m_wheelInstalledAngle == 0){
            throw new RuntimeException("You cannot move through RobotY Axis because the installed angle is horizontal");
        }
        double Rst = Y / this.getYPerDistance();
        return Rst;
    }
    public double getYPerDistance(){//Returns Y / Distance
        if(this.m_wheelInstalledAngle == -180 || this.m_wheelInstalledAngle == 0){
            return 0;
        }
        return Math.sin(-Math.toRadians(this.m_wheelInstalledAngle));
    }
    public double getXPerDistance(){ //Returns X / Distance
        if(this.m_wheelInstalledAngle == 90 || this.m_wheelInstalledAngle == -90){
            return 0;
        }
        return Math.cos(-Math.toRadians(this.m_wheelInstalledAngle));
    }
}