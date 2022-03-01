#include <iostream>
#include <fstream>
#include <string>
#include "BaseEmailHeaderType.cpp"
#include "GmailHeaderType.cpp"
#include "OutlookHeaderType.cpp"

using namespace std;

int main(int argc, char *argv[])
{
    string inputFile = "..\\data\\input.txt";
    ifstream fs(inputFile);
    string inputHeader;
    if (fs.is_open())
    {
        string temp;
        while (getline(fs, temp))
        {
            inputHeader.append(temp).append("\n");
        }

        fs.close();
        string output;
        std::smatch matches;
        std::regex reg("X-Google-Smtp-Source: (.+)");
        if (regex_search(inputHeader, matches, reg))
        {
            GmailHeaderType emailHeader(inputHeader);
            if (string(argv[1]) == "Subject")
            {
                output = emailHeader.getSubject();
            }
            else if (string(argv[1]) == "MessageID")
            {
                output = emailHeader.getMessageID();
            }
            else if (string(argv[1]) == "From")
            {
                output = emailHeader.getFrom();
            }
            else if (string(argv[1]) == "To")
            {
                output = emailHeader.getTo();
            }
            else if (string(argv[1]) == "Date")
            {
                output = emailHeader.getDate();
            }
            else if (string(argv[1]) == "ContentType")
            {
                output = emailHeader.getContentType();
            }
            else if (string(argv[1]) == "Received")
            {
                output = emailHeader.getReceived();
            }
            else if (string(argv[1]) == "ContentTransferEncoding")
            {
                output = emailHeader.getContentTransferEncoding();
            }
            else if (string(argv[1]) == "XGoogleSmtpSource")
            {
                output = emailHeader.getXGoogleSmtpSource();
            }
            else if (string(argv[1]) == "ReplyTo")
            {
                output = emailHeader.getReplyTo();
            }
            else if (string(argv[1]) == "MIMEVersion")
            {
                output = emailHeader.getMIMEVersion();
            }
            else if (string(argv[1]) == "DeliveredTo")
            {
                output = emailHeader.getDeliveredTo();
            }
        }
        else
        {
            OutlookHeaderType emailHeader(inputHeader);
            if (string(argv[1]) == "Subject")
            {
                output = emailHeader.getSubject();
            }
            else if (string(argv[1]) == "MessageID")
            {
                output = emailHeader.getMessageID();
            }
            else if (string(argv[1]) == "From")
            {
                output = emailHeader.getFrom();
            }
            else if (string(argv[1]) == "To")
            {
                output = emailHeader.getTo();
            }
            else if (string(argv[1]) == "Date")
            {
                output = emailHeader.getDate();
            }
            else if (string(argv[1]) == "ContentType")
            {
                output = emailHeader.getContentType();
            }
            else if (string(argv[1]) == "Received")
            {
                output = emailHeader.getReceived();
            }
            else if (string(argv[1]) == "ContentTransferEncoding")
            {
                output = emailHeader.getContentTransferEncoding();
            }
            else if (string(argv[1]) == "AuthenticationResults")
            {
                output = emailHeader.getAuthenticationResults();
            }
            else if (string(argv[1]) == "CC")
            {
                output = emailHeader.getCC();
            }
            else if (string(argv[1]) == "Date")
            {
                output = emailHeader.getDate();
            }
            else if (string(argv[1]) == "ThreadTopic")
            {
                output = emailHeader.getThreadTopic();
            }
            else if (string(argv[1]) == "ThreadIndex")
            {
                output = emailHeader.getThreadIndex();
            }
            else if (string(argv[1]) == "References")
            {
                output = emailHeader.getReferences();
            }
            else if (string(argv[1]) == "InReplyTo")
            {
                output = emailHeader.getInReplyTo();
            }
            else if (string(argv[1]) == "AcceptLanguage")
            {
                output = emailHeader.getAcceptLanguage();
            }
            else if (string(argv[1]) == "ContentLanguage")
            {
                output = emailHeader.getContentLanguage();
            }
            else if (string(argv[1]) == "XMSHasAttach")
            {
                output = emailHeader.getXMSHasAttach();
            }
            else if (string(argv[1]) == "XMSExchangeOrganizationSCL")
            {
                output = emailHeader.getXMSExchangeOrganizationSCL();
            }
        }

        fstream myFile;
        myFile.open("..\\data\\output.txt", ios::out);
        if (myFile.is_open())
        {
            myFile << output;
            myFile.close();
        }
        else
            cout << "Unable to open output file" << endl;
    }
    else
    {
        cout << "invalid input file";
    }
    return 0;
}