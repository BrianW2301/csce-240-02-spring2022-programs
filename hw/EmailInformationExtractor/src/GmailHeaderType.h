#ifndef GmailHeaderType_H_
#define GmailHeaderType_H_

#include "BaseEmailHeaderType.h"

class GmailHeaderType : public BaseEmailHeaderType
{
    std::string deliveredTo;
    std::string XGoogleSmtpSource;
    std::string replyTo;
    std::string MIMEVersion;

public:
    GmailHeaderType(std::string);
    std::string getXGoogleSmtpSource();
    std::string getReplyTo();
    std::string getMIMEVersion();
    std::string getDeliveredTo();
};

#endif