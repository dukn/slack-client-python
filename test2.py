import os
import time
from slackclient import SlackClient
import subprocess

#rc = subprocess.call("sleep.sh")

# starterbot's ID as an environment variable
BOT_ID = 'U5VF5JWMC'

# constants
AT_BOT = "<@" + BOT_ID + ">"
AT_BOT = ""
EXAMPLE_COMMAND = "do"

# instantiate Slack & Twilio clients

BOT_NAME = 'dcb'
DCB_TOKEN = 'xoxb-199515642726-zebkXi9EsjLM3FMuY1SEXHZ6'
slack_client = SlackClient(DCB_TOKEN)


def handle_command(command, channel):
    """
        Receives commands directed at the bot and determines if they
        are valid commands. If so, then acts on the commands. If not,
        returns back what it needs for clarification.
    """
    res = ":: Not sure what you mean. Use the *" + EXAMPLE_COMMAND + \
               "* command with numbers, delimited by spaces."
    if command.startswith(EXAMPLE_COMMAND):
        response = ":: Sure...write some more code then I can do that!"
        newcmd = command.split(EXAMPLE_COMMAND)[1]
        #print (newcmd)
        gk = "python -c 'print {}' > .tmpfile".format(newcmd)
        #print gk
        rc = subprocess.call(gk,shell = True)
        f = open('.tmpfile')
        res = f.read()
        print res 
        res = ":: {}".format(res)  
    slack_client.api_call("chat.postMessage", channel=channel,
                          text=res, as_user=True)


def parse_slack_output(slack_rtm_output):
    """
        The Slack Real Time Messaging API is an events firehose.
        this parsing function returns None unless a message is
        directed at the Bot, based on its ID.
    """
    output_list = slack_rtm_output
    if output_list and len(output_list) > 0:
        for output in output_list:
            if output and 'text' in output and AT_BOT in output['text']:
                # return text after the @ mention, whitespace removed
                if ":: " in output['text']:
                    return "",""
                return output['text'], output['channel']
                return output['text'].split(AT_BOT)[1].strip().lower(), \
                       output['channel']
    return None, None


if __name__ == "__main__":
    READ_WEBSOCKET_DELAY = 1 # 1 second delay between reading from firehose
    if slack_client.rtm_connect():
        print("StarterBot connected and running!")
        while True:
            command, channel = parse_slack_output(slack_client.rtm_read())

            if command and channel:
                print (command, channel)
                handle_command(command, channel)
            time.sleep(READ_WEBSOCKET_DELAY)
    else:
        print("Connection failed. Invalid Slack token or bot ID?")


