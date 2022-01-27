#include <iostream>
#include <string>
#include <fstream>
#include <sstream>
#define _USE_MATH_DEFINES
#include <math.h>

using namespace std;

int main()
{

    string file_name = "C:\\Users\\Brian\\Documents\\C++\\csce-240-02-spring2022-programs\\hw\\GeometricPropertyCalculator\\data\\input.txt";
    string out_file_name = "C:\\Users\\Brian\\Documents\\C++\\csce-240-02-spring2022-programs\\hw\\GeometricPropertyCalculator\\data\\output.txt";
    string line;
    string shape = "NULL";
    string answer;
    int measurementType = 0;

    cout << "(1) Area or\n(2) Perimeter?" << endl;
    cin >> measurementType;

    while (measurementType != 1 && measurementType != 2)
    {
        cout << measurementType << " is not a valid answer" << endl;
        cout << "(1) Area or\n(2) Perimeter?" << endl;
        cin >> measurementType;
    }

    ifstream myfile(file_name);
    if (myfile.is_open())
    {

        getline(myfile, line);

        myfile.close();

        if (line.substr(0, 6) == "CIRCLE")
        {
            shape = "CIRCLE";
            double radius = stoi(line.substr(7, line.length()));

            if (measurementType == 1)
            {
                double area = M_PI * pow(radius, 2);
                answer = shape;
                answer += " AREA ";
                answer += to_string(area);
            }
            else
            {
                double perimeter = 2 * M_PI * radius;
                answer = shape;
                answer += " PERIMETER ";
                answer += to_string(perimeter);
            }
        }
        else if (line.substr(0, 8) == "TRIANGLE")
        {
            shape = "TRIANGLE";

            double s1;
            double s2;
            double s3;

            istringstream iss(line);
            iss >> line >> s1 >> s2 >> s3;

            if (measurementType == 1)
            {
                double s = (s1 + s2 + s3) / 2;
                double area = sqrt(s * (s - s1) * (s - s2) * (s - s3));
                answer = shape;
                answer += " AREA ";
                answer += to_string(area);
            }
            else
            {
                double perimeter = s1 + s2 + s3;
                answer = shape;
                answer += " PERIMETER ";
                answer += to_string(perimeter);
            }
        }
        else if (line.substr(0, 9) == "RECTANGLE")
        {
            shape = "RECTANGLE";
            double length;
            double width;

            istringstream iss(line);
            iss >> line >> length >> width;

            if (measurementType == 1)
            {
                double area = length * width;
                answer = shape;
                answer += " AREA ";
                answer += to_string(area);
            }
            else
            {
                double perimeter = 2 * (length + width);
                answer = shape;
                answer += " PERIMETER ";
                answer += to_string(perimeter);
            }
        }
        else
        {
            answer = "invalid input";
        }

        fstream myFile;
        myFile.open(out_file_name, ios::out);
        if (myFile.is_open())
        {
            myFile << answer;
            myFile.close();
        }
        else
            cout << "Unable to open output file - " << file_name << endl;
    }
    else
        cout << "Unable to open input file - " << file_name << endl;

    return 0;
}