#include "GmailHeaderType.h"

GmailHeaderType::GmailHeaderType(std::string header) : BaseEmailHeaderType(header)
{
    std::smatch matches;

    std::regex reg("X-Google-Smtp-Source: (.+)");
    regex_search(header, matches, reg);
    XGoogleSmtpSource = matches[1];

    reg = "Reply-To: (.+)";
    regex_search(header, matches, reg);
    replyTo = matches[1];

    reg = "MIME-Version: (.+)";
    regex_search(header, matches, reg);
    MIMEVersion = matches[1];

    reg = "Delivered-To: (.+)";
    regex_search(header, matches, reg);
    deliveredTo = matches[1];
}

std::string GmailHeaderType::getXGoogleSmtpSource()
{
    return XGoogleSmtpSource;
}
std::string GmailHeaderType::getReplyTo()
{
    return replyTo;
}
std::string GmailHeaderType::getMIMEVersion()
{
    return MIMEVersion;
}
std::string GmailHeaderType::getDeliveredTo()
{
    return deliveredTo;
}