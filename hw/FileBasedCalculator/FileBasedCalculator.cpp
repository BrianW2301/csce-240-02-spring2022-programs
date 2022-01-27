#include <iostream>
#include <string>
#include <fstream>

using std::string;

int main()
{
    int num1, num2, ans;
    std::ifstream fs("input.text");

    if (fs.is_open())
    {
        string temp;

        while (std::getline(fs, temp))
        {
        }
    }

    fs.close();

    std::ofstream ofs("output.text");

    if (ofs.is_open())
    {
        string temp;

        for (int i = 0; i < 1; i++)
        {
        }
    }

    ofs.close();

    return 0;
}