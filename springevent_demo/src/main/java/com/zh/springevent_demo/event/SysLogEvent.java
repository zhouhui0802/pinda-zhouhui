package com.zh.springevent_demo.event;

import com.zh.springevent_demo.dto.OptLogDTO;
import org.springframework.context.ApplicationEvent;

public class SysLogEvent extends ApplicationEvent {

    public SysLogEvent(OptLogDTO optLogDTO) {
        super(optLogDTO);
    }
}
