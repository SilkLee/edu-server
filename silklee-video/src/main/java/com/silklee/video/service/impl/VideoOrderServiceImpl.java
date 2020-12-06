package com.silklee.video.service.impl;

import com.silklee.video.dao.EpisodeMapper;
import com.silklee.video.dao.PlayRecordMapper;
import com.silklee.video.dao.VideoMapper;
import com.silklee.video.dao.VideoOrderMapper;
import com.silklee.video.exception.XDException;
import com.silklee.video.model.entity.Episode;
import com.silklee.video.model.entity.PlayRecord;
import com.silklee.video.model.entity.Video;
import com.silklee.video.model.entity.VideoOrder;
import com.silklee.video.service.VideoOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class VideoOrderServiceImpl implements VideoOrderService {
    @Resource
    private VideoOrderMapper videoOrderMapper;

    @Resource
    private VideoMapper videoMapper;

    @Resource
    private EpisodeMapper episodeMapper;

    @Resource
    private PlayRecordMapper playRecordMapper;


    /**
     * 下单操作
     * 未来版本：优惠券抵扣，风控用户检查，生成订单基础信息，生成支付信息
     * @param userId
     * @param videoId
     * @return
     */
    @Override
    @Transactional
    public int save(int userId, int videoId) {

        //判断是否已经购买
        VideoOrder videoOrder = videoOrderMapper.findByUserIdAndVideoIdAndState(userId,videoId,1);

        if(videoOrder!=null){return  0;}

        Video video = videoMapper.findById(videoId);

        VideoOrder newVideoOrder = new VideoOrder();
        newVideoOrder.setCreateTime(new Date());
        newVideoOrder.setOutTradeNo(UUID.randomUUID().toString());
        newVideoOrder.setState(1);
        newVideoOrder.setTotalFee(video.getPrice());
        newVideoOrder.setUserId(userId);

        newVideoOrder.setVideoId(videoId);
        newVideoOrder.setVideoImg(video.getCoverImg());
        newVideoOrder.setVideoTitle(video.getTitle());

        int rows = videoOrderMapper.saveOrder(newVideoOrder);



        //生成播放记录
        if(rows == 1){
            Episode episode = episodeMapper.findFirstEpisodeByVideoId(videoId);
            if(episode == null){
                throw  new XDException(-1,"视频没有集信息，请运营人员检查");
            }
            PlayRecord playRecord = new PlayRecord();
            playRecord.setCreateTime(new Date());
            playRecord.setEpisodeId(episode.getId());
            playRecord.setCurrentNum(episode.getNum());
            playRecord.setUserId(userId);
            playRecord.setVideoId(videoId);
            playRecordMapper.saveRecord(playRecord);
        }

        return rows;
    }


    @Override
    public List<VideoOrder> listOrderByUserId(Integer userId) {

        return videoOrderMapper.listOrderByUserId(userId);
    }
}
