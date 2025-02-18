<script setup lang="ts">
import { ref } from 'vue'
import { onUnmounted } from 'vue'
import {
  createTextDrawingTaskUsingPost,
  getTextDrawingTaskUsingGet, uploadPictureByUrlUsingPost
} from '@/api/pictureController'
import { message } from 'ant-design-vue'
import type { CSSProperties } from 'vue';

// 定义组件内部的响应式数据
const prompt = ref<string>('')
const realPrompt = ref<string>('')
const drawingStyle = ref<string>('')
const negativePrompt = ref<string>('')
const resultImageUrl = ref<string>('')
const taskId = ref<string>()
const size = ref<string>('1024*1024')
const n = ref<number>(1)
const seed = ref<number>(1024)
const containerRef = ref()

const boxStyle: CSSProperties = {
  width: '100%',
  borderRadius: '6px',
};

// 创建任务
const createTask = async () => {
  // 如果 prompt 为空，则不执行创建任务操作
  if (!prompt.value) {
    message.error('正向描述不能为空')
    return
  }
  realPrompt.value = `${drawingStyle.value},${prompt.value} `
  // console.log(realPrompt.value)
  const res = await createTextDrawingTaskUsingPost({
    prompt: realPrompt.value,
    // negativePrompt: negativePrompt.value,
    parameters: {
      size: size.value,
      n: n.value,
      seed: seed.value,
    }
  })
  if (res.data.code === 0 && res.data.data) {
    message.success('创建任务成功，请耐心等待，不要退出界面')
    taskId.value = res.data.data.output.taskId
    startPolling()
  } else {
    message.error('创建任务失败，' + res.data.message)
  }
}

// 轮询定时器
let pollingTimer: NodeJS.Timeout = null

// 清理轮询定时器
const clearPolling = () => {
  if (pollingTimer) {
    clearInterval(pollingTimer)
    pollingTimer = null
    taskId.value = null
  }
}

// 开始轮询
const startPolling = () => {
  if (!taskId.value) return

  pollingTimer = setInterval(async () => {
    try {
      const res = await getTextDrawingTaskUsingGet({
        taskId: taskId.value
      })
      if (res.data.code === 0 && res.data.data) {
        const taskResult = res.data.data.output
        if (taskResult.taskStatus === 'SUCCEEDED') {
          message.success('生成图片任务成功')
          resultImageUrl.value = taskResult.results[0]?.url // 使用可选链操作符
          clearPolling()
          await handleUpload() // 等待 handleUpload 完成
        } else if (taskResult.taskStatus === 'FAILED') {
          message.error('生成图片任务失败')
          clearPolling()
        }
      }
    } catch (error) {
      console.error('轮询任务状态失败', error)
      message.error('检测任务状态失败，请稍后重试')
      clearPolling()
    }
  }, 3000) // 每隔 3 秒轮询一次
}

// 清理定时器，避免内存泄漏
onUnmounted(() => {
  clearPolling()
})

// 上传图片
const handleUpload = async () => {
  try {
    // resultImageUrl.value = 'https://image.meiye.art/pic_1628436817350?imageMogr2/thumbnail/640x/interlace/1';
    if (!resultImageUrl.value) {
      message.error('图片 URL 为空')
      return
    }

    const params: API.PictureUploadRequest = { fileUrl: resultImageUrl.value }
    const res = await uploadPictureByUrlUsingPost(params)
    if (res.data.code === 0 && res.data.data) {
      message.success('图片上传成功')
    } else {
      message.error('图片上传失败，' + res.data.message)
    }
  } catch (error) {
    message.error('图片上传失败')
    console.error('图片上传失败', error)
  }
}
const styles = [
  {
    value: 'default',
    label: '默认',
    description: '“auto”',
    url: 'https://img.alicdn.com/imgextra/i2/O1CN011O63Nx1kGxP0iWziu_!!6000000004657-0-tps-600-595.jpg'
  },
  {
    value: 'cartoon',
    label: '3D卡通',
    description: '“3D cartoon”',
    url: 'https://img.alicdn.com/imgextra/i4/O1CN01hskruP1KcJreu8a22_!!6000000001184-0-tps-600-595.jpg'
  },
  {
    value: 'anime',
    label: '动画',
    description: '“anime”',
    url: 'https://img.alicdn.com/imgextra/i2/O1CN01r0BnOq1mYTmrqtDp0_!!6000000004966-0-tps-600-595.jpg'
  },
  {
    value: 'oil',
    label: '油画',
    description: '“oil painting”',
    url: 'https://img.alicdn.com/imgextra/i1/O1CN01pWQ0lK1dgsVWjphQn_!!6000000003766-0-tps-600-595.jpg'
  },
  {
    value: 'watercolor',
    label: '水彩',
    description: '“watercolor”',
    url: 'https://img.alicdn.com/imgextra/i3/O1CN01I76QDg1kJhmKTCWUu_!!6000000004663-0-tps-600-595.jpg'
  },
  {
    value: 'sketch',
    label: '素描',
    description: '“sketch”',
    url: 'https://img.alicdn.com/imgextra/i2/O1CN0152hIXE1g0gs6wSXCo_!!6000000004080-0-tps-600-595.jpg'
  },
  {
    value: 'chinese painting',
    label: '中国画',
    description: '“sketch”',
    url: 'https://img.alicdn.com/imgextra/i3/O1CN01JZYQ4h20ZlWH7WjSp_!!6000000006864-0-tps-600-595.jpg'
  },
  {
    value: 'flat illustration',
    label: '扁平插画',
    description: '“sketch”',
    url: 'https://img.alicdn.com/imgextra/i2/O1CN01DWkQJk1SVSrbGSlsN_!!6000000002252-0-tps-600-595.jpg'
  }
]

// 选择样式
const selectStyle = (label: string) => {
  drawingStyle.value = `绘图风格: ${label} ` // 将样式标签拼接到 prompt 的前面
  // console.log(drawingStyle.value);
  // console.log(size);
}

const getBackgroundStyle = (url) => {
  // 使用模板字符串构建 CSS 样式
  return `background: linear-gradient(0deg, rgba(38, 36, 76, 0.1), rgba(38, 36, 76, 0.1)),
  url('${url}')
  center center / 93% no-repeat;`
}

</script>

<template>

  <a-row>
    <a-col :span="7" style="background-color: #fefefe; padding: 30px 30px;">
      <div id="components-affix-demo-target" ref="containerRef" class="scrollable-container">
        <p>正向prompt:</p>
        <a-textarea v-model:value="prompt" placeholder="请输入正向描述" :rows="4" />
        <br />
        <br />

        <p>Negative_prompt:</p>
        <a-textarea v-model:value="negativePrompt" :rows="4" placeholder="反向描述【可选】"
                    :maxlength="6" />
        <br>
        <br>

        <p>style:</p>
        <div>
          <a-row :gutter="[8,8]">
            <a-col class="gutter-row" :span="8" v-for="item in styles" :key="item.value"
                   :style="getBackgroundStyle(item.url)">
              <div class="gutter-box"
                   @click="selectStyle(item.label)">
                {{ item.label }}
                <br>
                {{ item.description }}
              </div>
            </a-col>
          </a-row>

        </div>

        <br>
        <p>size: </p>
        <div>
          <a-radio-group v-model:value="size">
            <a-radio-button value="1024*1024">1024*1024</a-radio-button>
            <a-radio-button value="720*1280">720*1280</a-radio-button>
            <a-radio-button value="1280*720">1280*720</a-radio-button>
          </a-radio-group>
        </div>

        <p>n: </p>
        <div>
          <a-radio-group v-model:value="n">
            <a-radio-button value="1">1张</a-radio-button>
            <a-radio-button value="2">2张</a-radio-button>
            <a-radio-button value="3">3张</a-radio-button>
            <a-radio-button value="4">4张</a-radio-button>
          </a-radio-group>
        </div>
        <br>
        <div>
          <a-row>

            <a-flex :style="{ ...boxStyle }" justify="space-between">
              <p>seed:</p>
              <a-input-number v-model:value="seed" :min="1" :max="4294967289" />
            </a-flex>
          </a-row>
          <a-row>
            <a-col :span="24">
              <a-slider v-model:value="seed" :min="1" :max="4294967289" />
            </a-col>
          </a-row>

          <br>
          <a-button type="primary" :loading="!!taskId" @click="createTask"
                    style="width: 100%;height: 50px"
          >
            开始生成
          </a-button>
        </div>
      </div>
    </a-col>

<!--    展示图片列-->
    <a-col :span="17" style="background-color: #f8f8f8;padding: 50px 50px">
      <p style="font-family: Arial, sans-serif;font-size: large">文本生成图像:</p>
      <p style="font-family: Arial, sans-serif;font-size: larger">{{ drawingStyle }}</p>

      <div>
        <a-flex vertical>
          <p style="font-family: Arial, sans-serif;font-size: larger">{{ prompt }}</p>
          <img
            v-if="resultImageUrl"
            style="width: 280px; object-fit: cover; border-radius: 20px"
            :src="resultImageUrl"
            loading="lazy"
           alt="文生图"/>
        </a-flex>
      </div>
    </a-col>
  </a-row>
</template>

<style scoped>
#components-affix-demo-target.scrollable-container {
  height: 70vh;
  overflow-y: scroll;
  scrollbar-width: none; /* 隐藏滚动条 */
}

.gutter-box {
  padding-top: 30px;
  box-shadow: 5px 5px 15px #888888;
  height: 80px;
  text-align: center;
  color: #fff;
  cursor: pointer;
}

.gutter-row {
  border-radius: 3px;
}
</style>
