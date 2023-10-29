package com.deviot.agripurebackend.advisory.domain.Services.message;


import com.deviot.agripurebackend.advisory.domain.model.commands.chat.CreateMessageCommand;

public interface IMessageCommandService {
    String handle (CreateMessageCommand createMessageCommand);
}
