package com.readers.be3.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.readers.be3.service.ScheduleService;
import com.readers.be3.vo.schedule.AddScheduleVO;
import com.readers.be3.vo.schedule.ViewScheduleVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "독서 일정 관리")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedule")
public class ScheduleAPIController {
    private final ScheduleService scheduleService;

    @Operation(summary = "새 일정 추가", description = "새 일정을 추가합니다.")
    @PostMapping("/add")
    public ResponseEntity<ViewScheduleVO> addSchedule(
        @Parameter(description = "스케쥴 입력 양식") @RequestBody AddScheduleVO data
    ) {
        return new ResponseEntity<>(scheduleService.addSchedule(data), HttpStatus.OK);
    }

    @Operation(summary = "일정 삭제", description = "일정을 삭제합니다.")
    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteSchedule(
        @Parameter(description = "삭제할 일정 번호") @RequestParam Long siSeq
    ) {
        scheduleService.deleteSchedule(siSeq);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}