literature-assistant/
├── settings.gradle
├── gradle/libs.versions.toml       # 版本目录，和原项目基本一致
├── gradlew / gradlew.bat
├── app/                            # 后端业务模块
│   ├── build.gradle
│   └── src/main/java/interview/guide/ （可改为 literature/assistant）
│       ├── common/                   # 公共层（90%复用原项目）
│       │   ├── result/               # 统一响应 Result<T>
│       │   ├── exception/            # 业务异常 + 全局异常处理器
│       │   ├── ai/                   # AI能力层（完全复用）
│       │   │   ├── LlmProviderRegistry.java
│       │   │   ├── StructuredOutputInvoker.java
│       │   │   └── PromptSanitizer.java
│       │   ├── async/                # Redis Stream 异步生产者/消费者模板
│       │   ├── annotation/           # 限流注解
│       │   ├── aspect/               # 限流切面 + Lua脚本
│       │   ├── config/               # 各类配置类
│       │   └── log/                  # 日志脱敏
│       ├── infrastructure/           # 基础设施层（大部分复用）
│       │   ├── file/                 # 文件存储 + 文档解析（Tika）
│       │   ├── redis/                # Redis 工具封装
│       │   ├── export/               # PDF导出（综述报告、对比报告）
│       │   └── mapper/               # MapStruct 实体映射
│       └── modules/                  # 业务模块（全部替换为文献方向）
│           ├── llmprovider/          # LLM服务商管理（完全复用）
│           ├── literature/           # 【新增】文献管理与解析
│           │   ├── controller/
│           │   ├── model/
│           │   ├── repository/
│           │   ├── service/
│           │   └── listener/         # 解析异步任务消费者
│           ├── knowledgebase/        # 【改造】文献知识库RAG
│           │   ├── controller/
│           │   ├── service/
│           │   └── listener/         # 向量化异步任务
│           ├── review/               # 【新增】综述与写作辅助
│           │   ├── controller/
│           │   ├── service/
│           │   └── listener/
│           ├── comparison/           # 【新增】多文献对比分析
│           │   ├── controller/
│           │   └── service/
│           └── research/             # 【新增】研究课题辅助
│               ├── controller/
│               └── service/
│       └── resources/
│           ├── application.yml
│           ├── prompts/               # 学术场景Prompt模板
│           │   ├── literature_parse.st
│           │   ├── review_generate.st
│           │   ├── innovation_dig.st
│           │   └── paper_polish.st
│           ├── scripts/               # Redis Lua限流脚本（复用）
│           └── db/migration/         # Flyway 表结构
├── frontend/                       # React前端
│   ├── src/
│   │   ├── pages/
│   │   │   ├── LibraryPage.tsx     # 文献库
│   │   │   ├── LiteratureDetail.tsx # 文献详情+解析
│   │   │   ├── KnowledgeQAPage.tsx # 知识库问答
│   │   │   ├── ReviewPage.tsx      # 综述生成
│   │   │   ├── ComparePage.tsx     # 文献对比
│   │   │   ├── ResearchPage.tsx    # 课题辅助
│   │   │   └── SettingsPage.tsx    # LLM设置
│   │   ├── components/
│   │   ├── api/
│   │   └── types/
├── docker-compose.yml
├── .env
└── docs/
