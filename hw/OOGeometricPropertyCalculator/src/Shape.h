#ifndef SHAPE_H_
#define SHAPE_H_

#define _USE_MATH_DEFINES
#include <math.h>
#include <String>

class Shape
{
    double area;
    double perimeter;

public:
    Shape(double);
    Shape(double, double);
    Shape(double, double, double);
    double getArea();
    double getPerimeter();
    std::string getErrorMessage();
};

#endif // SHAPE_H_